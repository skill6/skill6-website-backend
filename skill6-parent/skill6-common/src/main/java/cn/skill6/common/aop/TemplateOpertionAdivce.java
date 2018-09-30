package cn.skill6.common.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import com.google.common.base.CaseFormat;

import cn.skill6.common.aop.abst.BaseSpringAspect;

/**
 * 模板操作切面
 *
 * @author 何明胜
 * @version 1.1
 * @since 2018年9月22日 下午12:26:59
 */
@Aspect
@Component
public class TemplateOpertionAdivce extends BaseSpringAspect {

  @Override
  @Pointcut("execution(public * cn.skill6.common.entity.to.*.get*(..))")
  protected void aspectJMethod() {}

  @Override
  public void doBefore(JoinPoint joinPoint) {}

  @Override
  @Around(value = "aspectJMethod()")
  public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
    String methodName = getAimMethodName(joinPoint);

    String fieldName = methodName.substring(3);
    // 驼峰转下划线
    String fieldNameUnderScore = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, fieldName);

    return fieldNameUnderScore;
  }

  @Override
  public void doAfter(JoinPoint joinPoint) {}

  @Override
  public void doReturn(JoinPoint joinPoint, Object returnValue) {}

  @Override
  public void doThrowing(JoinPoint joinPoint, Exception e) {}
}
