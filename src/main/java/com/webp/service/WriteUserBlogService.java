package com.webp.service;

import static com.webp.model.QPostDetail.*;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Service;

import com.mysema.query.jpa.impl.JPAQuery;
import com.webp.model.PostDetail;
import com.webp.model.db.PostDetail_DB;
import com.webp.service.model.userBlog.BlogWriteRequest;
import com.webp.util.BooleanUtil;
import com.webp.util.Log;
import com.webp.util.TimeUtil;

@Service
public class WriteUserBlogService {

	@Autowired
	private EntityManager em;

	@Autowired
	private PostDetail_DB postDetail_DB;

	public String writeBlogPost(BlogWriteRequest request, HttpSession session) {

		SecurityContext con = (SecurityContext)session.getAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY);

		PostDetail post = setPostDetail(request, con);
		postDetail_DB.save(post);

		return "/" + request.categoryCode + "/" + post.postNo;
	}

	private PostDetail setPostDetail(BlogWriteRequest request, SecurityContext con) {
		PostDetail post = new PostDetail();

		String userId = con.getAuthentication().getName();

		post.postTitle = request.title;
		post.categoryCode = request.categoryCode;
		post.mapInfoFlag = BooleanUtil.toFlag(request.isMapIncluded);
		post.userId = userId;
		post.postNo = getNextPostNo(userId, request.categoryCode);
		post.createdUser = userId;
		post.createdTime = TimeUtil.getCurrentTimeStamp();
		post.contents = request.contents;

		Log.debug(post.toString());

		return post;
	}

	private int getNextPostNo(String userId, String categoryCode) {
		Integer postNo = new JPAQuery(em).from(postDetail).where(postDetail.userId.eq(userId)).singleResult(postDetail.postNo.max());

		if(postNo == null) {
			return 0;
		} else {
			return postNo + 1;
		}
	}
}
