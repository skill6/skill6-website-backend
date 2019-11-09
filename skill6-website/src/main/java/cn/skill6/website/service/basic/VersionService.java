package cn.skill6.website.service.basic;

import cn.skill6.common.entity.po.other.VersionInfo;
import cn.skill6.common.entity.vo.PageResult;
import cn.skill6.website.basic.VersionSvc;
import cn.skill6.website.dao.intf.basic.VersionDao;
import cn.skill6.website.util.sequence.SequenceManager;
import com.alibaba.dubbo.config.annotation.Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 网站版本信息服务类
 *
 * @author 何明胜 husen@hemingsheng.cn
 * @since 2019-09-05 00:46
 */
@Slf4j
@Service
@Component
public class VersionService implements VersionSvc {

    @Autowired
    private VersionDao versionDao;

    @Override
    public PageResult<VersionInfo> getVersionByPage(int pageSize, int pageNum) {
        return versionDao.getVersionByPage(pageSize, pageNum);
    }

    @Override
    public long addVersion(VersionInfo versionInfo) {
        long versionId = SequenceManager.getNextId();

        versionInfo.setVersionId(versionId);
        versionInfo.setVersionReleaseTime(new Date());

        versionDao.addVersionInfo(versionInfo);

        return versionId;
    }
}
