package com.atguigu.pojo;

public class Province {
private int id;
private String  name;
private String  suspect;  
private String  confirm;
private String  heal;
private String dead;
private String severe;
private String lastUpdateTime;



public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSuspect() {
	return suspect;
}
public void setSuspect(String suspect) {
	this.suspect = suspect;
}
public String getConfirm() {
	return confirm;
}
public void setConfirm(String confirm) {
	this.confirm = confirm;
}
public String getHeal() {
	return heal;
}
public void setHeal(String heal) {
	this.heal = heal;
}
public String getDead() {
	return dead;
}
public void setDead(String dead) {
	this.dead = dead;
}
public String getSevere() {
	return severe;
}
public void setSevere(String severe) {
	this.severe = severe;
}
public String getLastUpdateTime() {
	return lastUpdateTime;
}
public void setLastUpdateTime(String lastUpdateTime) {
	this.lastUpdateTime = lastUpdateTime;
}
public Province(int id, String name, String suspect, String confirm, String heal, String dead, String severe,
		String lastUpdateTime) {
	super();
	this.id = id;
	this.name = name;
	this.suspect = suspect;
	this.confirm = confirm;
	this.heal = heal;
	this.dead = dead;
	this.severe = severe;
	this.lastUpdateTime = lastUpdateTime;
}
public Province() {
	super();
}
@Override
public String toString() {
	return "Province [id=" + id + ", name=" + name + ", suspect=" + suspect + ", confirm=" + confirm + ", heal=" + heal
			+ ", dead=" + dead + ", severe=" + severe + ", lastUpdateTime=" + lastUpdateTime + "]";
}





}
