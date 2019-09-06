package com.yujun.util.session;

import java.util.Enumeration;

/**
 * @author yujun
 * @version 1.0.0
 * @date 2019/9/6 10:31
 * @description TODO
 **/
public interface Session {

    /** 
     * 获取session中指定的属性值
     * @author: yujun
     * @date: 2019/9/6
     * @description: TODO 
     * @param name
     * @return: {@link Object}
     * @exception: 
    */
    public Object getAttribute(String name);
    /** 
     * 获取session中的所有属性名集合
     * @author: yujun
     * @date: 2019/9/6
     * @description: TODO 
     * @param 
     * @return: {@link Enumeration< String>}
     * @exception: 
    */
    public Enumeration<String> getAttributeNames();
    
    /** 
     * 获取session的创建时间
     * @author: yujun
     * @date: 2019/9/6
     * @description: TODO 
     * @param 
     * @return: {@link long}
     * @exception: 
    */
    public long getCreationTime();
    
    /** 
     * 获取sessionId，全局唯一
     * @author: yujun
     * @date: 2019/9/6
     * @description: TODO 
     * @param 
     * @return: {@link String}
     * @exception: 
    */
    public String getId();
    
    /** 
     * 
     * @author: yujun
     * @date: 2019/9/6
     * @description: TODO 
     * @param 
     * @return: {@link long}
     * @exception: 
    */
    public long getLastAccessedTime();
    
    /** 
     * 设置session中的属性名，若已存在属性，则更新该属性，若不存在则添加属性
     * @author: yujun
     * @date: 2019/9/6
     * @description: TODO 
     * @param name
     * @param value
     * @return: 
     * @exception: 
    */
    public void setAttribute(String name, Object value);
    
    /** 
     * 按照属性名从session中删除属性
     * @author: yujun
     * @date: 2019/9/6
     * @description: TODO 
     * @param name
     * @return:
     * @exception: 
    */
    public void removeAttribute(String name);
    
    /** 
     * 设置session的有效时间
     * @author: yujun
     * @date: 2019/9/6
     * @description: TODO 
     * @param interval
     * @return: 
     * @exception: 
    */
    public void setMaxInactiveInterval(int interval);
    
    /** 
     * 获取session的有效时间
     * @author: yujun
     * @date: 2019/9/6
     * @description: TODO 
     * @param 
     * @return: {@link int}
     * @exception: 
    */
    public int getMaxInactiveInterval();

}
