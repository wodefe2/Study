package com.hll.sb20.service;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import org.springframework.core.MethodParameter;
import org.springframework.validation.DataBinder;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolverComposite;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author helili
 * @Create_Date 2018/8/20
 */
public class DataBindTest {
    public static void invoke(Object bean, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        method.invoke(bean, args);
    }

    public double add(double a, int b) {
        return a + b;
    }

    public static void addDefaultResolvers(HandlerMethodArgumentResolverComposite composite) {
        List<HandlerMethodArgumentResolver> resolvers = new ArrayList<>();

//
//        resolvers.add(new RequestParamMethodArgumentResolver(getBeanFactory(), false));
//        resolvers.add(new RequestParamMapMethodArgumentResolver());
//        resolvers.add(new PathVariableMethodArgumentResolver());
//        resolvers.add(new PathVariableMapMethodArgumentResolver());
//        resolvers.add(new MatrixVariableMethodArgumentResolver());
//        resolvers.add(new MatrixVariableMapMethodArgumentResolver());
//        resolvers.add(new ServletModelAttributeMethodProcessor(false));
//        resolvers.add(new RequestPartMethodArgumentResolver(getMessageConverters(), this.requestResponseBodyAdvice));
//        resolvers.add(new RequestHeaderMethodArgumentResolver(getBeanFactory()));
//        resolvers.add(new RequestHeaderMapMethodArgumentResolver());
//        resolvers.add(new ServletCookieValueMethodArgumentResolver(getBeanFactory()));
//        resolvers.add(new ExpressionValueMethodArgumentResolver(getBeanFactory()));
//        resolvers.add(new SessionAttributeMethodArgumentResolver());
//        resolvers.add(new RequestAttributeMethodArgumentResolver());
//
//        // Type-based argument resolution
//        resolvers.add(new ServletRequestMethodArgumentResolver());
//        resolvers.add(new ServletResponseMethodArgumentResolver());
//        resolvers.add(new RedirectAttributesMethodArgumentResolver());
//        resolvers.add(new ModelMethodProcessor());
//        resolvers.add(new MapMethodProcessor());
//        resolvers.add(new ErrorsMethodArgumentResolver());
//        resolvers.add(new SessionStatusMethodArgumentResolver());
//        resolvers.add(new UriComponentsBuilderMethodArgumentResolver());
//
//        // Catch-all
//        resolvers.add(new ServletModelAttributeMethodProcessor(true));
//

        composite.addResolvers(resolvers);
    }

    public static void main(String[] args) throws NoSuchMethodException {
//        Class clazz = DataBindTest.class;
//        Method addMethod = clazz.getMethod("add", double.class, int.class);
//        addMethod.getParameters();
//
//        DataBindTest dataBindTest = new DataBindTest();
//        try {
//            System.out.println(addMethod.invoke(dataBindTest,2f,5.0));
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
////        HandlerMethod handlerMethod = new HandlerMethod(dataBindTest, addMethod);
////        MethodParameter[] methodParameters = handlerMethod.getMethodParameters();
////        HandlerMethodArgumentResolverComposite argumentResolvers = new HandlerMethodArgumentResolverComposite();
////
////
////        Object[] arguments = new Object[methodParameters.length];
////        for (int i = 0; i < methodParameters.length; i++) {
////            MethodParameter methodParameter = methodParameters[i];
////            if (argumentResolvers.supportsParameter(methodParameter)) {
////
////            }
////
////        }
//        DataBinder dataBinder = new DataBinder(null);
        List<Parent> parentList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            parentList.add(new Parent(new Student(String.valueOf(i)), i));
        }
        parentList.forEach((parent) -> {

        });

        System.out.println(parentList);
        Parent[] parents = new Parent[parentList.size()];
        Arrays.sort(parentList.toArray(parents), Parent::compare);
        System.out.println(JSONObject.toJSONString(parents));
    }

    @Data
    public static class Student {
        private String name;

        public Student(String name) {
            this.name = name;
        }
    }

    @Data
    public static class Parent {
        private Student student;
        private String name;
        private Integer id;

        public static int compare(Parent a, Parent b) {
            Integer aId = a.getId();
            Integer bId = b.getId();
            if (aId > bId) {
                return 1;
            } else if (aId < bId) {
                return -1;
            }
            return 0;
        }

        public Parent(Student student, Integer id) {
            this.student = student;
            this.id = id;
        }
    }
}
