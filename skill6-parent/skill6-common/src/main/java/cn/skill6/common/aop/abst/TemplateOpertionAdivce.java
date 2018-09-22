package cn.skill6.common.aop.abst;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 模板操作切面
 *
 * @author 何明胜
 * @version 1.0.0
 * @since 2018年9月22日 下午12:26:59
 */
@Aspect
@Component
public class TemplateOpertionAdivce extends BaseSpringAspect {

  @Override
  @Pointcut("cn.skill6.common.entity.to.*")
  protected void aspectJMethod() {}

  @Override
  public void doBefore(JoinPoint joinPoint) {}

  @Override
  @Around(value = "aspectJMethod()")
  public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
    String methodName = getAimMethodName(joinPoint);

    return null;
  }

  @Override
  public void doAfter(JoinPoint joinPoint) {}

  @Override
  public void doReturn(JoinPoint joinPoint, Object returnValue) {}

  @Override
  public void doThrowing(JoinPoint joinPoint, Exception e) {}
}
