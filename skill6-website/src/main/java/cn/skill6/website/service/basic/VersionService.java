package cn.skill6.website.service.basic;

import cn.skill6.common.entity.vo.PageResult;
import cn.skill6.common.entity.vo.ResponseJson;
import cn.skill6.website.basic.VersionSvc;
import cn.skill6.website.dao.intf.basic.VersionDao;
import com.alibaba.dubbo.config.annotation.Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
    public ResponseJson getVersionByPage(int pageSize, int pageNum) {
        PageResult versionByPage = versionDao.getVersionByPage(pageSize, pageNum);

        return new ResponseJson(versionByPage);
    }
}
