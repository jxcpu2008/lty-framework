// js数组指定枚举键和值
var userType = [{"value" : 0, "desc" : "超级管理员"}, 
{"value" : 1, "desc" : "管理员"},
{"value" : 2, "desc" : "普通用户"}];

var userStatus = [{"value" : 0, "desc" : "锁定"}, 
{"value" : 1, "desc" : "正常"}, 
{"value" : 2, "desc" : "删除"}];

var displayUserType = function(value) {
	var type = userType.filter(function(currentValue, index, arr) {
		return (arr[index].value == value);
	});
	
	if (type.length > 0) {
		return type[0].desc;
	} else {
		return '';
	}
}

var displayUserStatus = function(value) {
	var status = userStatus.filter(function(currentValue, index, arr) {
		return (arr[index].value == value);
	});
	
	if (status.length > 0) {
		return status[0].desc;
	} else {
		return '';
	}
}

//var userType = [{"desc" : "超级管理员"}, 
//{"desc" : "管理员"},
//{"desc" : "普通用户"}];

//var userStatus = [{"desc" : "锁定"}, 
//{"desc" : "正常"}, 
//{"desc" : "删除"}];

// 使用js数组下标作为默认的枚举值
//var displayUserStatus = function(value) {
//	if (typeof(userStatus[value]) == "undefined") {
//		return '';
//	} else {
//		return userStatus[value].desc;
//	}
//}

//var displayUserType = function(value) {
//	if (typeof(userType[value]) == "undefined") {
//		return '';
//	} else {
//		return userType[value].desc;
//	}
//}

//针对数据库状态字段类型为int or char类型的转换
//var formatUserStatus = function(value) {
//	if (value == 0) {
//		return '锁定';
//	} else if (value == 1) {
//		return '正常';
//	} else if (value == 2) {
//		return '删除';
//	} else {
//		return '';
//	}
//}

//var formatUserType = function(value) {
//	if (value == 0) {
//		return '超级管理员';
//	} else if (value == 1) {
//		return '管理员';
//	} else if (value == 2) {
//		return '普通用户';
//	} else {
//		return '';
//	}
//}