package com.cts.fsd.projectmanager.mapper;

import org.springframework.stereotype.Component;

import com.cts.fsd.projectmanager.entity.ParentTaskEntity;
import com.cts.fsd.projectmanager.entity.ProjectEntity;
import com.cts.fsd.projectmanager.entity.TaskEntity;
import com.cts.fsd.projectmanager.entity.UserEntity;
import com.cts.fsd.projectmanager.pojo.ParentTaskPOJO;
import com.cts.fsd.projectmanager.pojo.ProjectPOJO;
import com.cts.fsd.projectmanager.pojo.TaskPOJO;
import com.cts.fsd.projectmanager.pojo.UserPOJO;

/**
 * @author Ashokan K [294457]
 * Mapper Class to map entity and pojo with each other
 */
@Component
public class ApplicationMapperObject {
	
	/**
	 * methodName() is used to map PARENT TASK POJO TO PARENT TASK ENTITY
	 * @param parentTaskPOJO
	 * @return
	 */
	public ParentTaskEntity mapParentTaskPojoToEntity (ParentTaskPOJO parentTaskPOJO){
		ParentTaskEntity parentTaskEntity = new ParentTaskEntity();
		
		if( parentTaskPOJO != null ) {
			parentTaskEntity.setParentId(parentTaskPOJO.getParentId());
			parentTaskEntity.setParentTask(parentTaskPOJO.getParentTask());
		}
		
		return parentTaskEntity;
	}
	
	
	/**
	 * methodName() is used to map PARENTTASK ENTITY TO PARENT TASK POJO
	 * @param parentTaskEntity
	 * @return
	 */
	public ParentTaskPOJO mapParentTaskEntityToPojo (ParentTaskEntity parentTaskEntity){
		ParentTaskPOJO parentTaskPOJO = new ParentTaskPOJO();
		
		if( parentTaskEntity != null ) {
			parentTaskPOJO.setParentId(new Long(parentTaskEntity.getParentId()).intValue());
			parentTaskPOJO.setParentTask(parentTaskEntity.getParentTask());
		}
		
		return parentTaskPOJO;
	}
	
	/**
	 * methodName() is used to map TASK POJO TO TASK ENTITY
	 * @param taskPOJO
	 * @return
	 */
	public TaskEntity mapTaskPojoToEntity (TaskPOJO taskPOJO){
		TaskEntity taskEntity = new TaskEntity();
		
		if( taskPOJO != null ) {
			taskEntity.setTaskId(taskPOJO.getTaskId());
			taskEntity.setTask(taskPOJO.getTask());
			if(taskPOJO.getStartDate() != null ) {
				taskEntity.setStartDate(new java.sql.Date(taskPOJO.getStartDate().getTime()));
			} else {
				taskEntity.setStartDate(null);
			}
			
			if(taskPOJO.getEndDate() != null ) {
				taskEntity.setEndDate(new java.sql.Date(taskPOJO.getEndDate().getTime()));
			} else {
				taskEntity.setEndDate(null);
			}
			
			taskEntity.setPriority(taskPOJO.getPriority());
			
		}
		
		return taskEntity;
	}


	public UserEntity mapUserPojoToEntity(UserPOJO userPOJO) {
		
		UserEntity userEntity = new UserEntity();
		
		if( userPOJO != null ) {
			userEntity.setUserId(userPOJO.getUserId());
			userEntity.setFirstName(userPOJO.getFirstName());
			userEntity.setLastName(userPOJO.getLastName());
			userEntity.setEmployeeId(userPOJO.getEmployeeId());
		}
		
		return userEntity;
	}


	public ProjectEntity mapProjectPojoToEntity(ProjectPOJO projectPOJO) {
		ProjectEntity projectEntity = new ProjectEntity();
		
		if( projectPOJO != null ) {
			projectEntity.setProjectId(projectPOJO.getProjectId());
			projectEntity.setProject(projectPOJO.getProject());
			if(projectPOJO.getStartDate() != null ) {
				projectEntity.setStartDate(new java.sql.Date(projectPOJO.getStartDate().getTime()));
			} else {
				projectEntity.setStartDate(null);
			}
			if(projectPOJO.getEndDate() != null ) {
				projectEntity.setEndDate(new java.sql.Date(projectPOJO.getEndDate().getTime()));
			} else {
				projectEntity.setEndDate(null);
			}
			
			projectEntity.setPriority(projectPOJO.getPriority());
		}
		
		return projectEntity;
	}
	
	/**
	 * mapTaskEntityToPojo() is used to map TASK ENTITY TO TASK POJO
	 * @param taskEntity
	 * @return
	 */
	public TaskPOJO mapTaskEntityToPojo (TaskEntity taskEntity){
		TaskPOJO taskPOJO = new TaskPOJO();
		
		if( taskEntity != null ) {
			taskPOJO.setTaskId(new Long(taskEntity.getTaskId()).intValue());
			taskPOJO.setTask(taskEntity.getTask());
			
			taskPOJO.setParentId((taskEntity.getParentTaskEntity() != null ? new Long(taskEntity.getParentTaskEntity().getParentId()).intValue() : 0));
			taskPOJO.setParentTask((taskEntity.getParentTaskEntity() != null ? taskEntity.getParentTaskEntity().getParentTask() : null));
			taskPOJO.setProjectId((taskEntity.getProjectEntity() != null ? new Long(taskEntity.getProjectEntity().getProjectId()).intValue() :  -1));
			taskPOJO.setUserId((taskEntity.getUserEntity() != null ? new Long(taskEntity.getUserEntity().getUserId()).intValue() : -1 ));
			
			if(null != taskEntity.getStartDate()) {
				taskPOJO.setStartDate(new java.util.Date(taskEntity.getStartDate().getTime()));
			} else {
				taskPOJO.setStartDate(null);
			}
			
			if(null != taskEntity.getEndDate()) {
				taskPOJO.setEndDate(new java.util.Date(taskEntity.getEndDate().getTime()));
			} else {
				taskPOJO.setEndDate(null);
			}
			
			taskPOJO.setPriority(taskEntity.getPriority());
		}
		
		return taskPOJO;
	}


	public UserPOJO mapUserEntityToPojo(UserEntity userEntity) {
		
		UserPOJO userPOJO = new UserPOJO();
		if (userEntity != null) {
			userPOJO.setUserId(new Long(userEntity.getUserId()).intValue());
			userPOJO.setFirstName(userEntity.getFirstName());
			userPOJO.setLastName(userEntity.getLastName());
			userPOJO.setEmployeeId(userEntity.getEmployeeId());
			
//			userPOJO.setProjectId((userEntity.getProjectEntity() != null ? new Long(userEntity.getProjectEntity().getProjectId()).intValue() : -1));
//			userPOJO.setTaskId((userEntity.getTaskEntity() != null ? new Long(userEntity.getTaskEntity().getTaskId()).intValue() : -1));
		}
		
		return userPOJO;
	}


	public ProjectPOJO mapProjectEntityToPojo(ProjectEntity projectEntity) {
		ProjectPOJO projectPOJO = new ProjectPOJO();
		
		if( projectEntity != null ) {
			projectPOJO.setProjectId(new Long(projectEntity.getProjectId()).intValue());
			projectPOJO.setProject(projectEntity.getProject());
			if(null != projectEntity.getStartDate()) {
				projectPOJO.setStartDate(new java.util.Date(projectEntity.getStartDate().getTime()));
			} else {
				projectPOJO.setStartDate(null);
			}
			if(null != projectEntity.getEndDate()) {
				projectPOJO.setEndDate(new java.util.Date(projectEntity.getEndDate().getTime()));
			} else {
				projectPOJO.setEndDate(null);
			}
			
			projectPOJO.setPriority(projectEntity.getPriority());
			projectPOJO.setUserId((projectEntity.getUserEntity() != null ? new Long(projectEntity.getUserEntity().getUserId()).intValue() : -1 ));
		}
		
		return projectPOJO;
	}
	
}
