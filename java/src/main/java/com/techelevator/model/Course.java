package com.techelevator.model;

public class Course {
    private Integer courseId;
    private String courseName;
    private String city;
    private String state;
    private Integer postalCode;
    private String googlePlusCode;
    private String imagePath;
    private Boolean redTeeExists;
    private Boolean goldTeeExists;
    private Boolean whiteTeeExists;
    private Boolean blackTeeExists;
    private Boolean blueTeeExists;
    private Boolean greenTeeExists;
    private Boolean silverTeeExists;
    private Integer redTeeFrontPar;
    private Integer goldTeeFrontPar;
    private Integer whiteTeeFrontPar;
    private Integer blackTeeFrontPar;
    private Integer blueTeeFrontPar;
    private Integer greenTeeFrontPar;
    private Integer silverTeeFrontPar;

    private Integer redTeeBackPar;
    private Integer goldTeeBackPar;
    private Integer whiteTeeBackPar;
    private Integer blackTeeBackPar;
    private Integer blueTeeBackPar;
    private Integer greenTeeBackPar;
    private Integer silverTeeBackPar;

    private Integer redTeeFrontYards;
    private Integer goldFrontYards;
    private Integer whiteFrontYards;
    private Integer blackFrontYards;
    private Integer blueFrontYards;
    private Integer greenFrontYards;
    private Integer silverFrontYards;
    private Integer redTeeBackYards;
    private Integer goldBackYards;
    private Integer whiteBackYards;
    private Integer blackBackYards;
    private Integer blueBackYards;
    private Integer greenBackYards;
    private Integer silverBackYards;

    public Course(String courseName, Integer redTeeFrontPar, Integer redTeeBackPar, Integer redTeeFrontYards, Integer redTeeBackYards) {
        this.courseName = courseName;
        this.redTeeFrontPar = redTeeFrontPar;
        this.redTeeBackPar = redTeeBackPar;
        this.redTeeFrontYards = redTeeFrontYards;
        this.redTeeBackYards = redTeeBackYards;
    }

    public Course() {
    }

    public Course(Integer courseId, String courseName, String city, String state, Integer postalCode, String googlePlusCode, String imagePath, Boolean redTeeExists, Boolean goldTeeExists, Boolean whiteTeeExists, Boolean blackTeeExists, Boolean blueTeeExists, Boolean greenTeeExists, Boolean silverTeeExists, Integer redTeeFrontPar, Integer goldTeeFrontPar, Integer whiteTeeFrontPar, Integer blackTeeFrontPar, Integer blueTeeFrontPar, Integer greenTeeFrontPar, Integer silverTeeFrontPar, Integer redTeeBackPar, Integer goldTeeBackPar, Integer whiteTeeBackPar, Integer blackTeeBackPar, Integer blueTeeBackPar, Integer greenTeeBackPar, Integer silverTeeBackPar, Integer redTeeFrontYards, Integer goldFrontYards, Integer whiteFrontYards, Integer blackFrontYards, Integer blueFrontYards, Integer greenFrontYards, Integer silverFrontYards, Integer redTeeBackYards, Integer goldBackYards, Integer whiteBackYards, Integer blackBackYards, Integer blueBackYards, Integer greenBackYards, Integer silverBackYards) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.googlePlusCode = googlePlusCode;
        this.imagePath = imagePath;
        this.redTeeExists = redTeeExists;
        this.goldTeeExists = goldTeeExists;
        this.whiteTeeExists = whiteTeeExists;
        this.blackTeeExists = blackTeeExists;
        this.blueTeeExists = blueTeeExists;
        this.greenTeeExists = greenTeeExists;
        this.silverTeeExists = silverTeeExists;
        this.redTeeFrontPar = redTeeFrontPar;
        this.goldTeeFrontPar = goldTeeFrontPar;
        this.whiteTeeFrontPar = whiteTeeFrontPar;
        this.blackTeeFrontPar = blackTeeFrontPar;
        this.blueTeeFrontPar = blueTeeFrontPar;
        this.greenTeeFrontPar = greenTeeFrontPar;
        this.silverTeeFrontPar = silverTeeFrontPar;
        this.redTeeBackPar = redTeeBackPar;
        this.goldTeeBackPar = goldTeeBackPar;
        this.whiteTeeBackPar = whiteTeeBackPar;
        this.blackTeeBackPar = blackTeeBackPar;
        this.blueTeeBackPar = blueTeeBackPar;
        this.greenTeeBackPar = greenTeeBackPar;
        this.silverTeeBackPar = silverTeeBackPar;
        this.redTeeFrontYards = redTeeFrontYards;
        this.goldFrontYards = goldFrontYards;
        this.whiteFrontYards = whiteFrontYards;
        this.blackFrontYards = blackFrontYards;
        this.blueFrontYards = blueFrontYards;
        this.greenFrontYards = greenFrontYards;
        this.silverFrontYards = silverFrontYards;
        this.redTeeBackYards = redTeeBackYards;
        this.goldBackYards = goldBackYards;
        this.whiteBackYards = whiteBackYards;
        this.blackBackYards = blackBackYards;
        this.blueBackYards = blueBackYards;
        this.greenBackYards = greenBackYards;
        this.silverBackYards = silverBackYards;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

    public String getGooglePlusCode() {
        return googlePlusCode;
    }

    public void setGooglePlusCode(String googlePlusCode) {
        this.googlePlusCode = googlePlusCode;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Boolean getRedTeeExists() {
        return redTeeExists;
    }

    public void setRedTeeExists(Boolean redTeeExists) {
        this.redTeeExists = redTeeExists;
    }

    public Boolean getGoldTeeExists() {
        return goldTeeExists;
    }

    public void setGoldTeeExists(Boolean goldTeeExists) {
        this.goldTeeExists = goldTeeExists;
    }

    public Boolean getWhiteTeeExists() {
        return whiteTeeExists;
    }

    public void setWhiteTeeExists(Boolean whiteTeeExists) {
        this.whiteTeeExists = whiteTeeExists;
    }

    public Boolean getBlackTeeExists() {
        return blackTeeExists;
    }

    public void setBlackTeeExists(Boolean blackTeeExists) {
        this.blackTeeExists = blackTeeExists;
    }

    public Boolean getBlueTeeExists() {
        return blueTeeExists;
    }

    public void setBlueTeeExists(Boolean blueTeeExists) {
        this.blueTeeExists = blueTeeExists;
    }

    public Boolean getGreenTeeExists() {
        return greenTeeExists;
    }

    public void setGreenTeeExists(Boolean greenTeeExists) {
        this.greenTeeExists = greenTeeExists;
    }

    public Boolean getSilverTeeExists() {
        return silverTeeExists;
    }

    public void setSilverTeeExists(Boolean silverTeeExists) {
        this.silverTeeExists = silverTeeExists;
    }

    public Integer getRedTeeFrontPar() {
        return redTeeFrontPar;
    }

    public void setRedTeeFrontPar(Integer redTeeFrontPar) {
        this.redTeeFrontPar = redTeeFrontPar;
    }

    public Integer getGoldTeeFrontPar() {
        return goldTeeFrontPar;
    }

    public void setGoldTeeFrontPar(Integer goldTeeFrontPar) {
        this.goldTeeFrontPar = goldTeeFrontPar;
    }

    public Integer getWhiteTeeFrontPar() {
        return whiteTeeFrontPar;
    }

    public void setWhiteTeeFrontPar(Integer whiteTeeFrontPar) {
        this.whiteTeeFrontPar = whiteTeeFrontPar;
    }

    public Integer getBlackTeeFrontPar() {
        return blackTeeFrontPar;
    }

    public void setBlackTeeFrontPar(Integer blackTeeFrontPar) {
        this.blackTeeFrontPar = blackTeeFrontPar;
    }

    public Integer getBlueTeeFrontPar() {
        return blueTeeFrontPar;
    }

    public void setBlueTeeFrontPar(Integer blueTeeFrontPar) {
        this.blueTeeFrontPar = blueTeeFrontPar;
    }

    public Integer getGreenTeeFrontPar() {
        return greenTeeFrontPar;
    }

    public void setGreenTeeFrontPar(Integer greenTeeFrontPar) {
        this.greenTeeFrontPar = greenTeeFrontPar;
    }

    public Integer getSilverTeeFrontPar() {
        return silverTeeFrontPar;
    }

    public void setSilverTeeFrontPar(Integer silverTeeFrontPar) {
        this.silverTeeFrontPar = silverTeeFrontPar;
    }

    public Integer getRedTeeBackPar() {
        return redTeeBackPar;
    }

    public void setRedTeeBackPar(Integer redTeeBackPar) {
        this.redTeeBackPar = redTeeBackPar;
    }

    public Integer getGoldTeeBackPar() {
        return goldTeeBackPar;
    }

    public void setGoldTeeBackPar(Integer goldTeeBackPar) {
        this.goldTeeBackPar = goldTeeBackPar;
    }

    public Integer getWhiteTeeBackPar() {
        return whiteTeeBackPar;
    }

    public void setWhiteTeeBackPar(Integer whiteTeeBackPar) {
        this.whiteTeeBackPar = whiteTeeBackPar;
    }

    public Integer getBlackTeeBackPar() {
        return blackTeeBackPar;
    }

    public void setBlackTeeBackPar(Integer blackTeeBackPar) {
        this.blackTeeBackPar = blackTeeBackPar;
    }

    public Integer getBlueTeeBackPar() {
        return blueTeeBackPar;
    }

    public void setBlueTeeBackPar(Integer blueTeeBackPar) {
        this.blueTeeBackPar = blueTeeBackPar;
    }

    public Integer getGreenTeeBackPar() {
        return greenTeeBackPar;
    }

    public void setGreenTeeBackPar(Integer greenTeeBackPar) {
        this.greenTeeBackPar = greenTeeBackPar;
    }

    public Integer getSilverTeeBackPar() {
        return silverTeeBackPar;
    }

    public void setSilverTeeBackPar(Integer silverTeeBackPar) {
        this.silverTeeBackPar = silverTeeBackPar;
    }

    public Integer getRedTeeFrontYards() {
        return redTeeFrontYards;
    }

    public void setRedTeeFrontYards(Integer redTeeFrontYards) {
        this.redTeeFrontYards = redTeeFrontYards;
    }

    public Integer getGoldFrontYards() {
        return goldFrontYards;
    }

    public void setGoldFrontYards(Integer goldFrontYards) {
        this.goldFrontYards = goldFrontYards;
    }

    public Integer getWhiteFrontYards() {
        return whiteFrontYards;
    }

    public void setWhiteFrontYards(Integer whiteFrontYards) {
        this.whiteFrontYards = whiteFrontYards;
    }

    public Integer getBlackFrontYards() {
        return blackFrontYards;
    }

    public void setBlackFrontYards(Integer blackFrontYards) {
        this.blackFrontYards = blackFrontYards;
    }

    public Integer getBlueFrontYards() {
        return blueFrontYards;
    }

    public void setBlueFrontYards(Integer blueFrontYards) {
        this.blueFrontYards = blueFrontYards;
    }

    public Integer getGreenFrontYards() {
        return greenFrontYards;
    }

    public void setGreenFrontYards(Integer greenFrontYards) {
        this.greenFrontYards = greenFrontYards;
    }

    public Integer getSilverFrontYards() {
        return silverFrontYards;
    }

    public void setSilverFrontYards(Integer silverFrontYards) {
        this.silverFrontYards = silverFrontYards;
    }

    public Integer getRedTeeBackYards() {
        return redTeeBackYards;
    }

    public void setRedTeeBackYards(Integer redTeeBackYards) {
        this.redTeeBackYards = redTeeBackYards;
    }

    public Integer getGoldBackYards() {
        return goldBackYards;
    }

    public void setGoldBackYards(Integer goldBackYards) {
        this.goldBackYards = goldBackYards;
    }

    public Integer getWhiteBackYards() {
        return whiteBackYards;
    }

    public void setWhiteBackYards(Integer whiteBackYards) {
        this.whiteBackYards = whiteBackYards;
    }

    public Integer getBlackBackYards() {
        return blackBackYards;
    }

    public void setBlackBackYards(Integer blackBackYards) {
        this.blackBackYards = blackBackYards;
    }

    public Integer getBlueBackYards() {
        return blueBackYards;
    }

    public void setBlueBackYards(Integer blueBackYards) {
        this.blueBackYards = blueBackYards;
    }

    public Integer getGreenBackYards() {
        return greenBackYards;
    }

    public void setGreenBackYards(Integer greenBackYards) {
        this.greenBackYards = greenBackYards;
    }

    public Integer getSilverBackYards() {
        return silverBackYards;
    }

    public void setSilverBackYards(Integer silverBackYards) {
        this.silverBackYards = silverBackYards;
    }
}
