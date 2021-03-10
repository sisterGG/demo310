package com.example.demo373.tool;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Obj2List {
    Field[] field;
    Object model;
    public Obj2List(Object o) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this.field = o.getClass().getDeclaredFields();
        model=o;

    }
    public List<String> getkeys(){

        List<String> key_list=new ArrayList<String>();
 //
        for(int j=0 ; j<field.length ; j++){
            key_list.add(field[j].getName());

        }
        System.out.println(key_list );
        return key_list;
    }
    public List<String> gettypes(){
  //

        List<String> type_list=new ArrayList<String>();
        //
        for(int j=0 ; j<field.length ; j++){
            type_list.add(field[j].getGenericType().toString());

        }
        System.out.println(type_list );
        return type_list;
    }

    public List<String> getvalues() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //

        List<String> value_list=new ArrayList<String>();
        for(int j=0 ; j<field.length ; j++){                 //遍历所有属性
                         String name = field[j].getName();             //获取属性的名字

                         System.out.println("attribute name:"+name);
                         name = name.substring(0,1).toUpperCase()+name.substring(1); //将属性的首字符大写，方便构造get，set方法
                         String type = field[j].getGenericType().toString();             //获取属性的类型
                         if(type.equals("class java.lang.String")){         //如果type是类类型，则前面包含"class "，后面跟类名
                                         Method m = this.model.getClass().getMethod("get"+name);
                                         String value = (String) m.invoke(this.model);             //调用getter方法获取属性值
                                         if(value != null){
                                                         System.out.println("attribute value:"+value);
                                             value_list.add(value.toString());

                                         }
                         }
                         else if(type.equals("class java.lang.Integer")||type.equals("int")){
                                         Method m =     this.model.getClass().getMethod("get"+name);
                                         Integer value = (Integer) m.invoke(    this.model);
                                         if(value != null){
                                                         System.out.println("attribute value:"+value);
                                             value_list.add(value.toString());

                                         }
                         }
                         else if(type.equals("class java.lang.Short")){
                                         Method m =     this.model.getClass().getMethod("get"+name);
                                         Short value = (Short) m.invoke(    this.model);
                                         if(value != null){
                                                         System.out.println("attribute value:"+value);
                                             value_list.add(value.toString());
                                         }
                         }
                         else if(type.equals("class java.lang.Double")){
                                         Method m =     this.model.getClass().getMethod("get"+name);
                                         Double value = (Double) m.invoke(    this.model);
                                         if(value != null){
                                                         System.out.println("attribute value:"+value);
                                             value_list.add(value.toString());

                                         }
                         }
                         else if(type.equals("class java.lang.Boolean")){
                                         Method m =     this.model.getClass().getMethod("get"+name);
                                         Boolean value = (Boolean) m.invoke(    this.model);
                                         if(value != null){
                                                         System.out.println("attribute value:"+value);
                                             value_list.add(value.toString());

                                         }
                         }
                         else if(type.equals("class java.util.Date")){
                                         Method m =     this.model.getClass().getMethod("get"+name);
                                         Date value = (Date) m.invoke(    this.model);
                                         if(value != null){
                                                         System.out.println("attribute value:"+value.toLocaleString());
                                             value_list.add(value.toString());

                                         }
                         }   else{
                             value_list.add("cannot recg");

                         }
         }

        System.out.println(value_list );
        return value_list;
    }

}
