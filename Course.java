package com.neuedu.entity;

/**
* @ClassName: Course
* @Description:课程类
* @author cps
* @date 2019年9月7日 上午11:07:33
*
*/
public class Course {
    public Course() {
    	
    }
    
    public Course(Integer cId, String cName, String tName, Integer sId) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.tName = tName;
		this.sId = sId;
	}

	private Integer cId;
    private String cName;
    private String tName;
    private Integer sId;
	public Integer getcId() {
		return cId;
	}
	public void setcId(Integer cId) {
		this.cId = cId;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
	public Integer getsId() {
		return sId;
	}
	public void setsId(Integer sId) {
		this.sId = sId;
	}
	@Override
	public String toString() {
		return "Course [cId=" + cId + ", cName=" + cName + ", tName=" + tName + ", sId=" + sId + "]";
	}
    
}
