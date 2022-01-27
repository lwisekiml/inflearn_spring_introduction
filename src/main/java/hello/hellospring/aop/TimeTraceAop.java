package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeTraceAop {

    // hello.hellospring 패키지 하위에 다 적용
    // Service하위만 시간을 측정하고 싶다면
    // execution(* hello.hellospring.service..*(..))
    // 으로 하면 된다.
    @Around("execution(* hello.hellospring..*(..))") // hello.hellospring 패키지 하위에 다 적용
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("START: " + joinPoint.toLongString());
        try {
            return joinPoint.proceed();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END: " + joinPoint.toLongString() + " " + timeMs + "ms");
        }
    }
}
