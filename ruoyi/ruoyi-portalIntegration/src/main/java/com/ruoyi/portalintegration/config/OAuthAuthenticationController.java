//package com.ruoyi.portalintegration.config;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.commons.collections.CollectionUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.para.esc.sdk.oauth.IOAuth20Service;
//import com.para.esc.sdk.oauth.builder.OAuthServiceBuilder;
//import com.para.esc.sdk.oauth.client.model.UserInfo;
//import com.para.esc.sdk.oauth.exceptions.OAuthApiException;
//import com.para.esc.sdk.oauth.model.OAuth20Config;
//import com.para.esc.sdk.oauth.model.Token;
//import com.para.esc.sdk.oauth.utils.OAuthConfigUtil;
//import com.para.osc.framework.common.Application;
//import com.para.osc.framework.common.Constants;
//import com.para.osc.framework.common.emum.CommonEnums;
//import com.para.osc.framework.common.emum.CommonEnums.MENUTYPE;
//import com.para.osc.framework.common.emum.CommonEnums.STATUS;
//import com.para.osc.framework.common.util.MenuCompare;
//import com.para.osc.framework.common.util.StringUtil;
//import com.para.osc.framework.common.util.StringUtils;
//import com.para.osc.framework.security.model.PrMenu;
//import com.para.osc.framework.security.model.PrRole;
//import com.para.osc.framework.security.model.PrRoleMenu;
//import com.para.osc.framework.security.model.PrUser;
//import com.para.osc.framework.security.model.PrUserRole;
//import com.para.osc.framework.security.webservice.IPrFreeMenuService;
//import com.para.osc.framework.security.webservice.IPrMenuService;
//import com.para.osc.framework.security.webservice.IPrRoleService;
//import com.para.osc.framework.security.webservice.IPrUserService;
//import com.para.osc.framework.security.view.MenuInfo;
//import com.para.osc.framework.security.view.UserAuthInfo;
//
//
//@Controller
//public class OAuthAuthenticationController {
//
//	@Autowired
//	private IPrUserService userService;
//
//	@Autowired
//	private IPrRoleService roleService;
//
//	@Autowired
//	private IPrMenuService menuService;
//
//	@Autowired
//	private IPrFreeMenuService freeService;
//
//
//	/**
//	 * 进行OAuth认证
//	 *
//	 * @param httpResponse
//	 * @throws IOException
//	 */
//	@RequestMapping("/oauth_authentication")
//	public void doOauthAuthentication(HttpServletResponse httpResponse)
//			throws IOException {
//		OAuthConfigUtil configUtil = new OAuthConfigUtil("appIDP");
//		OAuth20Config configInfo = new OAuth20Config(configUtil.getClientId(),
//				configUtil.getClientSecret(), configUtil.getRedirectUri(),
//				configUtil.getAuthorizeUrl(), configUtil.getAccessTokenUrl());
//		IOAuth20Service webservice = new OAuthServiceBuilder(configInfo)
//				.build20Service();
//		// 生成认证跳转地址
//		String redUrl = webservice.getAuthorizationUrl();
//		// 跳转到认证中心,进行认证
//		httpResponse.sendRedirect(redUrl);
//		return;
//	}
//
//	/**
//	 * OAuth认证成功后的回调地址
//	 *
//	 * @throws ServletException
//	 */
//	@RequestMapping("/callback")
//	public void oauthCallback(@RequestParam("code") String code,
//			HttpServletRequest request, HttpServletResponse response)
//			throws ServletException {
//
//		OAuthConfigUtil configUtil = new OAuthConfigUtil("appIDP");
//		OAuth20Config configInfo = new OAuth20Config(configUtil.getClientId(),
//				configUtil.getClientSecret(), configUtil.getRedirectUri(),
//				configUtil.getAuthorizeUrl(), configUtil.getAccessTokenUrl());
//		// OAuthInformation info = new OAuthInformation(client_id,
//		// client_secret, redirect_uri,
//		// authorizeUrl, accessTokenUrl);
//
//		try {
//			IOAuth20Service webservice = new OAuthServiceBuilder(configInfo)
//					.build20Service();
//			Token accessToken = webservice.getAccessToken(code);
//			UserInfo oauthUser = new UserInfo(accessToken);
//			try {
//				oauthUser = oauthUser.requestUserInfo(configUtil.getUserInfoUrl());
//			} catch (OAuthApiException e) {
//				e.printStackTrace();
//			}
//			if (oauthUser != null) {
//				// 根据uid从DB/Ldap中查找User对象
//				PrUser user = userService.findUserByUid(oauthUser.getId());
//				if (user != null) {
//					String principal = user.getUid();
//					boolean isAdmin = userService.checkSuperSystem(user.getId());
//					if (user.getStatus().equals(STATUS.VALID.getVal()) || isAdmin) {
//						Authentication authentication = wrapLoginUser(principal, null, user);
//						SecurityContextHolder.getContext().setAuthentication(
//								authentication);
//						if (Application.getUserAuthInfo() != null) {
//							response.sendRedirect(request.getContextPath() + "/index");
//							return;
//						}
//					}
//				}
//			}
//			Application.setAttribute("errMsg", "用户不存在或者用户已停用！");
//			response.sendRedirect(request.getContextPath() + "/oauth_error");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	@RequestMapping("/oauth_error")
//	public ModelAndView error() {
//		return new ModelAndView("authentication/oauth_error");
//	}
//
//
//	public Authentication wrapLoginUser(String principal, String password, PrUser user) {
//        List<PrMenu> listMenus = new ArrayList<PrMenu>();
//        List<String> btnCodeList = new ArrayList<String>();
//        UserAuthInfo userInfo = new UserAuthInfo();
//        userInfo.setUserModel(user);
//        Application.setUserAuthInfo(userInfo);
//        userAuthInfo(user, listMenus, btnCodeList);
//        ArrayList<GrantedAuthority> grantedAuthority = new ArrayList<GrantedAuthority>();
//        grantedAuthority.add(new SimpleGrantedAuthority("ROLE_USER"));
//        // set user,menus,buttoncodes,roles to session
//        Application.setMenus(listMenus);
//        Application.setBtnCodes(btnCodeList);
//        // Application.setRoles(listRoles);
//        return new UsernamePasswordAuthenticationToken(principal, password, grantedAuthority);
//    }
//
//	private void userAuthInfo(PrUser userModel, List<PrMenu> menuList, List<String> btnCodeList) throws BadCredentialsException {
//        // 是否超级管理员
//        boolean isAdmin = userService.checkSuperSystem(userModel.getId());
//        if (!isAdmin) {
//            List<PrRole> listPrRoles = roleService.findRoleInfoByUserId(userModel.getId());
//            if (CollectionUtils.isNotEmpty(listPrRoles)) {
//                // session中存放当前用户角色
//                Application.setRoles(listPrRoles);
//                for (PrRole tempPrRole : listPrRoles) {
//                    if (tempPrRole.getId().equals(Constants.DEFAULT_SYSTEM_ROOT_ID.SYSTEM_SUPER_ROLE_MANAGER)) {
//                        isAdmin = true;
//                        break;
//                    }
//                }
//            }
//        }
//        if (!isAdmin) {
//            MenuInfo info = new MenuInfo();
//            PrUserRole roleUserModel = new PrUserRole();
//            roleUserModel.setUserId(userModel.getId());
//
//            PrRole roleModel = new PrRole();
//            // 只取系统角色
//            roleModel.setRoleType("0");// ROLETYPE.SYSTEM.getVal()
//            // 状态：有效
//            roleModel.setStatus(STATUS.VALID.getVal());
//            PrRoleMenu roleMenuModel = new PrRoleMenu();
//            PrMenu menuModel = new PrMenu();
//            menuModel.setStatus(STATUS.VALID.getVal());
//            // menuModel.setParentId(Constants.DEFAULT_SYSTEM_ROOT_ID.SYSTEM_MENU_ROOT_ID);//
//            // 一级菜单
//            menuModel.setMenuType(MENUTYPE.MENU.getVal());// 只取菜单
//            info.setMenuModel(menuModel);
//            List<PrMenu> lvallList;
//            List<PrMenu> lv0List;
//            lvallList = menuService.queryListMenu(info, roleUserModel, roleModel, roleMenuModel, menuModel);
//
//            freeService.sortByFreeMenu(lvallList);
//
//            lv0List = new ArrayList<PrMenu>();
//            if (CollectionUtils.isNotEmpty(lvallList)) {
//                initMenuTree(lvallList, lv0List, new PrMenu(), 0);
//                menuList.addAll(lv0List);
//                MenuCompare.sortMenu(menuList);
//            }
//            menuModel.setMenuType(CommonEnums.MENUTYPE.FUNCTION.getVal());// 只取按钮
//            List<PrMenu> btnList = menuService.queryListMenu(info, roleUserModel, roleModel, roleMenuModel, menuModel);
//            if (CollectionUtils.isNotEmpty(btnList)) {
//                List<String> codeFieldList = StringUtil.convertList(btnList, "menuCode");
//                btnCodeList.addAll(codeFieldList);
//            }
//        }
//        else {
//            PrMenu tempMenu = new PrMenu();
//            tempMenu.setStatus(CommonEnums.STATUS.VALID.getVal());
//            tempMenu.setMenuType(CommonEnums.MENUTYPE.MENU.getVal());// 只取菜单
//            List<PrMenu> lvAllList = menuService.find(tempMenu);
//            freeService.sortByFreeMenu(lvAllList);
//            if (CollectionUtils.isNotEmpty(lvAllList)) {
//                List<PrMenu> lv0List = new ArrayList<PrMenu>();
//                initMenuTree(lvAllList, lv0List, new PrMenu(), 0);
//                menuList.addAll(lv0List);
//                MenuCompare.sortMenu(menuList);
//            }
//            tempMenu.setMenuType(CommonEnums.MENUTYPE.FUNCTION.getVal());
//            List<PrMenu> btnList = menuService.find(tempMenu);
//            if (CollectionUtils.isNotEmpty(btnList)) {
//                List<String> codeFieldList = StringUtil.convertList(btnList, "menuCode");
//                btnCodeList.addAll(codeFieldList);
//            }
//        }
//        // 菜单国际化处理
//        convert2LocaleMenu(menuList);
//    }
//
//    private void convert2LocaleMenu(List<PrMenu> list) {
//        if (CollectionUtils.isNotEmpty(list)) {
//            for (PrMenu menu : list) {
//                String menuName = Application.getResourceValue("ui.menus." + menu.getMenuCode());
//                if (StringUtils.isNotEmpty(menuName)) {
//                    menu.setMenuName(menuName);
//                }
//                List<PrMenu> childrenList = menu.getChildren();
//                if (CollectionUtils.isNotEmpty(childrenList)) {
//                    convert2LocaleMenu(childrenList);
//                }
//            }
//        }
//    }
//
//    private void initMenuTree(List<PrMenu> allList, List<PrMenu> resultList, PrMenu currMenu, int level) {
//        List<PrMenu> lv0List = resultList;
//        List<PrMenu> lv1List = new ArrayList<PrMenu>();
//        if (CollectionUtils.isNotEmpty(allList)) {
//            for (int i = 0; i < allList.size(); i++) {
//                PrMenu menu = allList.get(i);
//                if (level == 0) {
//                    if (menu.getId().equals(Constants.DEFAULT_SYSTEM_ROOT_ID.SYSTEM_MENU_ROOT_ID)) {
//                        allList.remove(menu);
//                        i--;
//                        continue;
//                    }
//                    if (menu.getParentId().equals(Constants.DEFAULT_SYSTEM_ROOT_ID.SYSTEM_MENU_ROOT_ID)) {
//                        lv0List.add(menu);
//                        initMenuTree(allList, lv0List, menu, 1);
//                    }
//
//                }
//                if (level == 1) {
//                    if (menu.getParentId().equals(currMenu.getId())) {
//                        lv1List.add(menu);
//                        initMenuTree(allList, lv0List, menu, 2);
//                    }
//                }
//                if (level == 2) {
//                    if (menu.getParentId().equals(currMenu.getId())) {
//                        lv1List.add(menu);
//                    }
//                }
//
//            }
//            if (level != 0) {
//                if (CollectionUtils.isNotEmpty(lv1List)) {
//                    currMenu.setChildren(lv1List);
//                }
//            }
//        }
//    }
//}
