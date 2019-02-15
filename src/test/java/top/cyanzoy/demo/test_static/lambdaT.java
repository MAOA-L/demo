package top.cyanzoy.demo.test_static;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @author MAOA-L
 * @package top.cyanzoy.demo.test_static
 * @create 2019-02-01 11:16
 * @description: ${DESCRIPTION}
 */
public class lambdaT {


    private int salary;

    public lambdaT(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "lambdaT{" +
                "salary=" + salary +
                '}';
    }

    public static void main(String[] args) {

        MyFunc1 a = lambdaT::new;
        lambdaT b = a.func(123);
        System.out.println(b);

//        ((HttpSecurity)((HttpSecurity)((AuthorizedUrl)http.authorizeRequests().anyRequest()).authenticated().and()).formLogin().and()).httpBasic();


    }

}
