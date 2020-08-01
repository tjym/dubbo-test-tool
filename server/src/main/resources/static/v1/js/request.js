/**
 * Nora工具包.<br>
 * 请放在jq后加载.
 */
var request = window.request || {
    path : {
        svrList: "/dt/svr/list",
        svrSave: "/dt/svr/save",
        svrDelete: "/dt/svr/delete",
        methodList: "/dt/method/list",
        methodSave: "/dt/method/save",
        methodDelete: "/dt/method/delete",
        paramList: "/dt/param/list",
        paramSave: "/dt/param/save",
        paramDelete: "/dt/param/delete",
        paramNextSort: "/dt/param/sort/next",
        caseList: "/dt/case/list",
        caseSave: "/dt/case/save",
        caseDelete: "/dt/case/delete",
        caseParamList: "/dt/case/param/list",
        caseParamSave: "/dt/case/param/save",
        caseParamDelete: "/dt/case/param/delete",
        executeCmd: "/dt/execute/cmd"
    },

    "listSvr":function(params,successFun,failFun){
        this.Get(this.path.svrList,params,successFun,failFun);
    },
    "saveSvr":function(params,successFun,failFun){
        this.Post(this.path.svrSave,params,successFun,failFun);
    },
    "deleteSvr":function(params,successFun,failFun){
        this.Post(this.path.svrDelete,params,successFun,failFun);
    },

    "listMethod":function(params,successFun,failFun){
        this.Get(this.path.methodList,params,successFun,failFun);
    },
    "saveMethod":function(params,successFun,failFun){
        this.Post(this.path.methodSave,params,successFun,failFun);
    },
    "deleteMethod":function(params,successFun,failFun){
        this.Post(this.path.methodDelete,params,successFun,failFun);
    },
    "listParam":function(params,successFun,failFun){
        this.Get(this.path.paramList,params,successFun,failFun);
    },
    "saveParam":function(params,successFun,failFun){
        this.Post(this.path.paramSave,params,successFun,failFun);
    },
    "deleteParam":function(params,successFun,failFun){
        this.Post(this.path.paramDelete,params,successFun,failFun);
    },
    "getParamNextSort":function(params,successFun,failFun){
        this.Get(this.path.paramNextSort,params,successFun,failFun);
    },
    "listCase":function(params,successFun,failFun){
        this.Get(this.path.caseList,params,successFun,failFun);
    },
    "saveCase":function(params,successFun,failFun){
        this.Post(this.path.caseSave,params,successFun,failFun);
    },
    "deleteCase":function(params,successFun,failFun){
        this.Post(this.path.caseDelete,params,successFun,failFun);
    },
    "listParamCase":function(params,successFun,failFun){
        this.Get(this.path.caseParamList,params,successFun,failFun);
    },
    "saveParamCase":function(params,successFun,failFun){
        this.Post(this.path.caseParamSave,params,successFun,failFun);
    },
    "deleteParamCase":function(params,successFun,failFun){
        this.Post(this.path.caseParamDelete,params,successFun,failFun);
    },
    "cmdExecute":function(params,successFun,failFun){
        this.Post(this.path.executeCmd,params,successFun,failFun);
    },


	"Post":  function(url,prams, successFun, failFun) {
		$.ajax({
			type : "POST",
			url : url,
			data: prams,
			success : function(result){
				if(result.code==0){
					successFun(result.data);
				}else{
					failFun(result.msg);
				}
			},
			error: function(xhr, msg, e) {
				if (typeof(failFun) == "function") {
					failFun(msg);
				} else {
					alert("Nora.request函数调用出错：" + msg + " " + e);
				}
			}
		});
	},
	"Get":  function(url, prams, successFun, failFun) {
		$.ajax({
			type : "GET",
			url : url,
			data: prams,
			success : function(result){
				if(result.code==0){
					successFun(result.data);
				}else{
					failFun(result.message);
				}
			},
			error: function(xhr, msg, e) {
				if (typeof(failFun) == "function") {
					failFun(xhr, msg, e);
				} else {
					alert("Nora.request函数调用出错：" + msg + " " + e);
				}
			}
		});
	}
};
