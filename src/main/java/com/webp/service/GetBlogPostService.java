package com.webp.service;

import static com.webp.model.QPostDetail.*;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysema.query.jpa.impl.JPAQuery;
import com.webp.model.PostDetail;

@Service
public class GetBlogPostService {
	@Autowired
	private EntityManager em;

	public List<PostDetail> getPost(String categoryCode, String postNo) {

		List<PostDetail> response = null;

		if (postNo != null) {
			response =	new JPAQuery(em).from(postDetail)
									.where(postDetail.categoryCode.eq(categoryCode)
											.and(postDetail.postNo.eq(Integer.parseInt(postNo)))
											)
									.list(postDetail);
		} else {
			response =	new JPAQuery(em).from(postDetail)
					.where(postDetail.categoryCode.eq(categoryCode))
					.list(postDetail);
		}

		return response;
	}
}
