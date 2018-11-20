package cn.skill6.common.entity.po.rbac;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * RBAC会话存储
 *
 * @author 何明胜
 * @version 1.2
 * @since 2018年9月24日 上午2:44:03
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RbacSession {

  private Long sessionId;

  private Date sessionCreateTime;

  private Date sessionUpdateTime;

  private Boolean sessionValid;

  private String sessionContent;
}
