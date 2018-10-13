package com.webp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.webp.model.VerificationEmail;
import com.webp.service.GetCommonInfoService;
import com.webp.service.RegUserService;
import com.webp.service.UserCheckService;
import com.webp.service.model.userCreate.RegUserRequest;
import com.webp.service.model.userCreate.RegUserResponse;
import com.webp.util.Log;
import com.webp.util.StrUtil;

@Controller
public class CreateRegUserController {

	@Autowired
	private GetCommonInfoService blogService;

	@Autowired
	private RegUserService regUserService;

	@Autowired
	private UserCheckService userCheckService;

	/**
	 * 「Ａｊａｘ」ID検証
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/user/registration", method = RequestMethod.GET)
	public String createRegUser(Model model, HttpSession session) {
		model.addAttribute("header", blogService.getCommonMenu("/user/registration", session));
		if(session.getAttribute("email") != null) {
			session.removeAttribute("email");
			session.removeAttribute("pass");
			return "page_expired";
		}
		return "createRegUser";
	}

	@RequestMapping(value = "/user/step1/id", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String checkId(Model model, RegUserRequest request, HttpSession session) {
		RegUserResponse res = userCheckService.checkId(request);
		return new Gson().toJson(res);
	}

	/**
	 * 「Ａｊａｘ」パスワード検証
	 * @param model
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/user/step1/pass", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String checkPass(Model model, RegUserRequest request, HttpSession session) {
		RegUserResponse res = userCheckService.checkPass(request);
		return new Gson().toJson(res);
	}

	@RequestMapping(value = "/user/step2/verfy", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String checkverfy(Model model, HttpSession session) {
		RegUserResponse res = new RegUserResponse();
		VerificationEmail  reg = new VerificationEmail();

		String email = (String)session.getAttribute("email");

		if(StrUtil.isEmpty(email)) {
			res.message = "セッションが満了されました。";
		} else {
			reg = regUserService.getVerfyInfoByEmail(email);
			res.message = !reg.isVerificationed.equals("1") ? "メールを開いて認証を行ってください。" : null;
		}
		Log.debug(res.message);
		return new Gson().toJson(res);
	}

	/**
	 * 会員加入２-メール認証
	 * @param model
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/user/registration2", method = RequestMethod.POST)
	public String createRegUser2(Model model, RegUserRequest request, HttpSession session) {
		model.addAttribute("header", blogService.getCommonMenu("/user/registration2", session));

		if(request.email == null) {
			return  "page_expired";
		}
		// メール認証用文字列をＤＢに登録する。
		regUserService.regVerification(request);

		Log.debug(request.email + " / " + request.pass );
		// セッション管理（前、先遷移防止）
		session.setAttribute("email", request.getEmail());
		session.setAttribute("pass", request.getPass());

		//画面表示用
		model.addAttribute("email", request.getEmail());

		return "createRegUser2";
	}
	@RequestMapping(value = "/user/registration3", method = RequestMethod.POST)
	public String createRegUser3(Model model, HttpSession session) {
		model.addAttribute("header", blogService.getCommonMenu("/user/registration3", session));

		String email = (String) session.getAttribute("email");

		VerificationEmail verification = regUserService.getVerfyInfoByEmail(email);
		if(verification == null || verification.verfiyStr == null) {
			return "page_expired";
		} else {
			regUserService.changeFlag(verification, "1");
			Log.debug(verification.email  + "認証完了");
			// セッション管理（前、先遷移防止）
			model.addAttribute("blog_name", verification.email.split("@")[0] );
			return "createRegUser3";
		}
	}

	/**
	 * メール認証ＵＲＬから接続した場合
	 * @param verfiStr
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/reg/{verfiStr}", method = RequestMethod.GET)
	public String blogMain(@PathVariable("verfiStr") String verfiStr, Model model) {
		VerificationEmail verification = regUserService.getVerfyInfoByStr(verfiStr);
		if(verification == null || verification.verfiyStr == null) {
			return "page_expired";
		} else {
			regUserService.changeFlag(verification, "1");
			Log.debug(verification.email  + "認証完了");
			// セッション管理（前、先遷移防止）
			model.addAttribute("email", verification.email);
			return "createRegUser3";
		}
	}
}
