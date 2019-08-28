package cn.skill6.website.util;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.codec.CodecSupport;
import org.apache.shiro.codec.Hex;
import org.apache.shiro.util.ByteSource;

import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Arrays;

/**
 * 采用redis缓存shiro, 在序列化的时候,
 * SimpleByteSource类没有实现Serializable接口,导致序列化失败,
 * SimpleByteSource没有默认构造方法,导致反序列化的时候失败,
 * 自定义ByteSource的实现类,模仿SimpleByteSource的方法.
 *
 * @author 何明胜 husen@hemingsheng.cn
 * @since 2019-08-28 22:57
 */
public class ByteSourceSerializable implements ByteSource, Serializable {

    private static final long serialVersionUID = -7054596836953858596L;

    private byte[] bytes;
    private String cachedHex;
    private String cachedBase64;

    public ByteSourceSerializable() {
    }

    public ByteSourceSerializable(byte[] bytes) {
        this.bytes = bytes;
    }

    public ByteSourceSerializable(char[] chars) {
        this.bytes = CodecSupport.toBytes(chars);
    }

    public ByteSourceSerializable(String string) {
        this.bytes = CodecSupport.toBytes(string);
    }

    public ByteSourceSerializable(ByteSource source) {
        this.bytes = source.getBytes();
    }

    public ByteSourceSerializable(File file) {
        this.bytes = (new ByteSourceSerializable.BytesHelper()).getBytes(file);
    }

    public ByteSourceSerializable(InputStream stream) {
        this.bytes = (new ByteSourceSerializable.BytesHelper()).getBytes(stream);
    }

    public static boolean isCompatible(Object o) {
        return o instanceof byte[] || o instanceof char[] || o instanceof String || o instanceof ByteSource || o instanceof File || o instanceof InputStream;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    @Override
    public byte[] getBytes() {
        return bytes;
    }

    @Override
    public String toHex() {
        if (cachedHex == null) {
            cachedHex = Hex.encodeToString(getBytes());
        }
        return cachedHex;
    }

    @Override
    public String toBase64() {
        if (cachedBase64 == null) {
            cachedBase64 = Base64.encodeToString(getBytes());
        }

        return cachedBase64;
    }

    @Override
    public boolean isEmpty() {
        return bytes == null || bytes.length == 0;
    }

    @Override
    public String toString() {
        return toBase64();
    }

    @Override
    public int hashCode() {
        return bytes != null && bytes.length != 0 ? Arrays.hashCode(bytes) : 0;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof ByteSource) {
            ByteSource bs = (ByteSource) o;
            return Arrays.equals(getBytes(), bs.getBytes());
        }

        return false;
    }

    private static final class BytesHelper extends CodecSupport {
        private BytesHelper() {
        }

        byte[] getBytes(File file) {
            return toBytes(file);
        }

        byte[] getBytes(InputStream stream) {
            return toBytes(stream);
        }
    }
}
