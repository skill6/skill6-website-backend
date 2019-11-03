package cn.skill6.website.dao.impl.basic;

import cn.skill6.common.entity.po.other.VersionInfo;
import cn.skill6.common.entity.vo.PageResult;
import cn.skill6.common.exception.general.NullPointerException;
import cn.skill6.website.dao.intf.basic.VersionDao;
import cn.skill6.website.dao.mappers.basic.VersionInfoMapper;
import cn.skill6.website.util.sequence.SequenceManager;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * 版本信息操作实现类
 *
 * @author 何明胜
 * @since 2018年8月28日 上午12:20:18
 */
@Slf4j
@Repository
public class VersionDaoImpl implements VersionDao {

    @Autowired
    private VersionInfoMapper versionInfoMapper;

    @Override
    public int deleteByVersionId(Long versionId) {
        log.warn("删除id为{}的版本信息", versionId);

        return versionInfoMapper.deleteByPrimaryKey(versionId);
    }

    @Override
    public void addVersionInfo(VersionInfo versionInfo) {
        if (versionInfo.getUserId() == null) {
            throw new NullPointerException("版本发布用户id不能为null");
        }
        if (versionInfo.getVersionNumber() == null) {
            throw new NullPointerException("版本号不能为null");
        }
        if (versionInfo.getVersionContent() == null) {
            throw new NullPointerException("版本内容不能为null");
        }

        Long versionId = versionInfo.getVersionId();
        if (versionId == null) {
            versionId = SequenceManager.getNextId();
        }

        versionInfo.setVersionReleaseTime(new Date());
        versionInfoMapper.insert(versionInfo);
        log.info("成功添加id为{}的版本信息,{}", versionId, versionInfo);
    }

    @Override
    public VersionInfo findByVersionId(Long versionId) {
        if (versionId == null) {
            throw new NullPointerException("版本id不能为null");
        }

        VersionInfo versionInfo = versionInfoMapper.selectByPrimaryKey(versionId);
        log.info("成功找到id为{}的版本信息,{}", versionId, versionInfo);

        return versionInfo;
    }

    @Override
    public List<VersionInfo> findAll() {
        List<VersionInfo> versionInfos = versionInfoMapper.selectAll();
        log.info("找到所有版本信息,{}", versionInfos);

        return versionInfos;
    }

    @Override
    public void modifyByVersionId(VersionInfo versionInfo) {
        if (versionInfo.getVersionId() == null) {
            throw new NullPointerException("版本id不能为null");
        }

        if (versionInfo.getUserId() == null) {
            throw new NullPointerException("版本发布用户id不能为null");
        }
        if (versionInfo.getVersionNumber() == null) {
            throw new NullPointerException("版本号不能为null");
        }
        if (versionInfo.getVersionContent() == null) {
            throw new NullPointerException("版本内容不能为null");
        }

        versionInfoMapper.updateByPrimaryKey(versionInfo);
        log.info("成功修改版本信息为{}", versionInfo);
    }

    @Override
    public PageResult<VersionInfo> getVersionByPage(int pageSize, int pageNum) {
        log.info("getVersionByPage, pageSize: {}, pageNum: {}", pageSize, pageNum);

        Page<VersionInfo> page = PageHelper.startPage(pageNum, pageSize);

        List<VersionInfo> versionInfos = versionInfoMapper.selectAll();
        log.info("versionInfos size: {}, total: {}", versionInfos.size(), page.getTotal());

        return new PageResult<>(page.getTotal(), pageSize, pageNum, versionInfos);
    }
}
