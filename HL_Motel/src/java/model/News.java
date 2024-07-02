/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public class News {

    private String newId;
    private String newTitle;
    private String description;
    private String img;
    private Date createAt;

    public News() {
    }

    public News(String newId, String newTitle, String description) {
        this.newId = newId;
        this.newTitle = newTitle;
        this.description = description;
    }

    
    
    public News(String newId, String newTitle, String description, String img, Date createAt) {
        this.newId = newId;
        this.newTitle = newTitle;
        this.description = description;
        this.img = img;
        this.createAt = createAt;
    }

    public String getNewId() {
        return newId;
    }

    public void setNewId(String newId) {
        this.newId = newId;
    }

    public String getNewTitle() {
        return newTitle;
    }

    public void setNewTitle(String newTitle) {
        this.newTitle = newTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    @Override
    public String toString() {
        return "News{" + "newId=" + newId + ", newTitle=" + newTitle + ", description=" + description + ", img=" + img + ", createAt=" + createAt + '}';
    }

    
    
    
    
}
