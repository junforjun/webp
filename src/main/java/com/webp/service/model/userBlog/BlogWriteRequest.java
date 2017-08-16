package com.webp.service.model.userBlog;

import java.util.Arrays;

import com.webp.service.model.service.common.ApiRequest;

public class BlogWriteRequest extends ApiRequest{

	/** タイトル  */
	public String title;

	/** マップ情報有りフラグ  */
	public String isMapIncluded;

	/** マップ情報（X）  */
	public String mapX;

	/** マップ情報（Y）  */
	public String mapY;

	/** 住所  */
	public String address;

	/** カテゴリコード  */
	public String categoryCode;

	/** 内容  */
	public String contents;

	/** イメージ配列  */
	public String[] imgArr;

	/** 公開レベル */
	public String level;

	@Override
	public String toString() {
		return "BlogWriteRequest [" + (title != null ? "title=" + title + ", " : "")
				+ (isMapIncluded != null ? "isMapIncluded=" + isMapIncluded + ", " : "")
				+ (mapX != null ? "mapX=" + mapX + ", " : "") + (mapY != null ? "mapY=" + mapY + ", " : "")
				+ (address != null ? "address=" + address + ", " : "")
				+ (categoryCode != null ? "categoryCode=" + categoryCode + ", " : "")
				+ (contents != null ? "content=" + contents + ", " : "")
				+ (imgArr != null ? "imgArr=" + Arrays.toString(imgArr) + ", " : "")
				+ (level != null ? "level=" + level : "") + "]";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsMapIncluded() {
		return isMapIncluded;
	}

	public void setIsMapIncluded(String isMapIncluded) {
		this.isMapIncluded = isMapIncluded;
	}

	public String getMapX() {
		return mapX;
	}

	public void setMapX(String mapX) {
		this.mapX = mapX;
	}

	public String getMapY() {
		return mapY;
	}

	public void setMapY(String mapY) {
		this.mapY = mapY;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String[] getImgArr() {
		return imgArr;
	}

	public void setImgArr(String[] imgArr) {
		this.imgArr = imgArr;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}


}
