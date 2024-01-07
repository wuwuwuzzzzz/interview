package com.example.interview.flow;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

/**
 * 发布订阅
 *
 * @author wxz
 * @date 12:52 2024/1/7
 */
public class FlowDemo
{
    /**
     * @author wxz
     * @date 12:53 2024/1/7
     */
    public static void main(String[] args)
    {
        // 定义一个发布者，发布数据
        try (SubmissionPublisher<String> publisher = new SubmissionPublisher<>())
        {

            // 定义一个订阅者
            Flow.Subscriber<String> subscriber = new Flow.Subscriber<>()
            {
                @Override
                public void onSubscribe(Flow.Subscription subscription)
                {
                    System.out.println(Thread.currentThread() + " 订阅开始了：" + subscription);
                    subscription.request(1);
                }

                //
                @Override
                public void onNext(String item)
                {
                    System.out.println(Thread.currentThread() + " 订阅者接收到数据：" + item);
                }

                @Override
                public void onError(Throwable throwable)
                {
                    System.out.println(Thread.currentThread() + " 订阅者接收到错误信号：" + throwable);
                }

                @Override
                public void onComplete()
                {
                    System.out.println(Thread.currentThread() + " 订阅者接收到完成信号");
                }
            };

            // 发布 10 条数据
            for (int i = 0; i < 10; i++)
            {
                publisher.submit("p-" + i);
            }

            publisher.subscribe(subscriber);
        }
    }
}
