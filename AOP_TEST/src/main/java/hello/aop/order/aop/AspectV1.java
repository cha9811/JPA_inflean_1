package hello.aop.order.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Import;

@Slf4j
@Aspect
//빈 성생됨
@Import(Aspect.class)
public class AspectV1 {

    //포인트컷 지정
    @Around("execution(* hello.aop.order..*(..))")
    public Object doLog(ProceedingJoinPoint joinPoint) throws Throwable {
        //advice를 의미
        log.info("[log] {}",joinPoint.getSignature());  //joinpoint 시그니처
        return joinPoint.proceed();
    }
}
