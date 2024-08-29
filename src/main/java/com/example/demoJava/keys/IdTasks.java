// package com.example.demoJava.keys;

// import java.io.Serializable;

// import jakarta.persistence.Column;

// public class IdTasks implements Serializable {

// @Column(name = "user_id")
// private int userId;

// @Column(name = "project_id")
// private int projectId;

// public IdTasks() {
// // Không cần thân hàm khởi tạo mặc định khi sử dụng JPA
// }

// public IdTasks(int userId, int projectId) {
// this.userId = userId;
// this.projectId = projectId;
// }

// public int getUserId() {
// return userId;
// }

// public void setUserId(int userId) {
// this.userId = userId;
// }

// public int getProjectId() {
// return projectId;
// }

// public void setProjectId(int projectId) {
// this.projectId = projectId;
// }

// // Nếu cần, bạn có thể thêm các phương thức equals() và hashCode() cho
// // Serializable
// // để xử lý so sánh và băm dữ liệu khóa chính kết hợp.
// }