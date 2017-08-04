<%@ taglib prefix="s" uri="/struts-tags"%>
<s:form action="addUser" >
  <s:textfield name="username" label="User Name" value="" />
  <s:textfield name="password" label="Password" value="" />
  <s:textfield name="email" label="Email"/>
  <s:checkbox name="isAdmin" label="Is Admin?"/>
  <s:submit />
</s:form>

