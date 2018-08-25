package com.sgai.meter.transmission.web;
import java.util.ArrayList;
/**
 * 处理角色和功能之间的关系.
 * @author ppliu
 *
 */
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgmart.auth.user.entity.Function;
import com.sgmart.auth.user.entity.RoleFunction;
import com.sgmart.auth.user.service.FunctionService;
import com.sgmart.auth.user.service.RoleFunctionService;
import com.sgmart.auth.user.service.UserRoleService;
import com.szx.core.web.support.UserServletContext;

@RestController
@RequestMapping(value = "/sys/role_function")
public class RoleFunctionController{

	@Autowired
	private RoleFunctionService roleFunctionService;
	@Autowired
	private FunctionService functionService;
	@Autowired
	private UserRoleService userRoleService;

	/**
	 * 为角色更新菜单（功能）,先删除中间表之间的关系，然后重新添加.
	 * 
	 * @return
	 */
	@RequestMapping("/deleteThenInsert")
	public List<RoleFunction> deleteThenInsert(@RequestBody List<RoleFunction> roleFunctions) {
		return roleFunctionService.deleteThenInsert(roleFunctions);
	}
	/**
	 * 查询所有菜单，并修改该角色所具有的菜单中的checked属性
	 * @param roleId
	 * @return
	 */
	@RequestMapping("/queryChecked")
	public List<Function> queryChecked(Long roleId){
		List<Function> allFunction = functionService.selectAll();
		List<Function> ownFunction = roleFunctionService.queryFunctionsOfRole(roleId);
		List<Function> resultFunction = changeFunctionCheckedStatus(allFunction, ownFunction);
		return resultFunction;
	}
	
	private List<Function> changeFunctionCheckedStatus(List<Function> allFunctions, List<Function> functionsJoinRoleId) {
		if (functionsJoinRoleId != null && !functionsJoinRoleId.isEmpty()) {
			for (int i = 0; i < allFunctions.size(); i++) {
				Function function = allFunctions.get(i);
				for (int j = 0; j < functionsJoinRoleId.size(); j++) {
					Function functionJoinRoleId = functionsJoinRoleId.get(j);
					if (function.getId().equals(functionJoinRoleId.getId())) {
						function.setIsChecked(true);
					}
				}
			}
		}
		return allFunctions;
	}
	
	/**
	 * 过滤用户可用的操作权限
	 * @param functionCodes
	 * @return
	 */
	@RequestMapping("/filterOperator")
	public List<Function> filterOperatorFunctions(List<String> functionCodes){
		List<Long> roleIds=userRoleService.selectRoleIdsByUserId(UserServletContext.getUserSubject().getUserId());
		List<Function> fs = new ArrayList<>();
		for(Long roleId : roleIds) {
			fs.addAll(roleFunctionService.filterOperatorFunctions(roleId, functionCodes));
		}
		return fs;
	}
}
