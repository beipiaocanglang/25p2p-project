package study.shiro.service.impl;

import org.springframework.stereotype.Service;
import study.shiro.service.IBookService;

/**
 * author: canglang
 * create time: 2018/3/25 11:24
 */
@Service
public class BookServiceImpl implements IBookService {


    public void update() {
        System.out.println("执行了service 的 update方法。。。。。。");
    }

    public void delete() {
        System.out.println("执行了service 的 update方法。。。。。。");
    }

    public void add() {
        System.out.println("执行了service 的 update方法。。。。。。");
    }

    public void find() {
        System.out.println("执行了service 的 update方法。。。。。。");
    }
}
