package com.fme.bean;

public class DetailBook extends BookDTO {

    private String resume;

    private boolean isStocked;

    private String quantityToCommand;

    private String imgName;

    public DetailBook(BookDTO book, String resume, boolean isStocked, String quantityToCommand, String imgName) {
        super(book.getTitle(), book.getPrice(), book.getAuthor(), book.getId());
        this.resume = resume;
        this.isStocked = isStocked;
        this.quantityToCommand = quantityToCommand;
        this.imgName = imgName;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public boolean isStocked() {
        return isStocked;
    }

    public void setStocked(boolean isStocked) {
        this.isStocked = isStocked;
    }

    public String getQuantityToCommand() {
        return quantityToCommand;
    }

    public void setQuantityToCommand(String quantityToCommand) {
        this.quantityToCommand = quantityToCommand;
    }
}
