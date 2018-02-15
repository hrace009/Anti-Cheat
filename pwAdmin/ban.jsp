<%@ page language="java" pageEncoding="GB2312"%>
<%@ page import="java.util.*"%>
<%@ page import="com.goldhuman.auth.AuthFilter"%>
<%@ page import="com.goldhuman.service.interfaces.LogInfo"%>
<%@ page import="com.goldhuman.service.interfaces.SimpleRoleBean"%>
<%@ page import="com.goldhuman.service.interfaces.GMService"%>
<%@ page import="com.goldhuman.service.GMServiceImpl"%>
<%@ page import="org.apache.commons.logging.LogFactory"%>

<%request.setCharacterEncoding("GB2312");

    String reason = "User has been banned for 10min due to violating server policy";

    LogInfo info = null;
    int uid = -1;
    GMService gs = new GMServiceImpl();
    String xGetAccountID = request.getParameter("id");
    int rid = Integer.parseInt(xGetAccountID);


    int gmroleid = 32;
    int localsid = -1;
    int forbid_time = 600;
    byte fbd_type = 100;
    int flag = gs.forbidRole(fbd_type, gmroleid, localsid, rid,forbid_time, reason, info);

%>
