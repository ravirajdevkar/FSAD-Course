
import React, { useState } from "react";

function StudentManager() {

  const initialStudents = [
    { id: 1, name: "Rahul", course: "Computer Science" },
    { id: 2, name: "Anita", course: "Electronics" },
    { id: 3, name: "Kiran", course: "Mechanical" },
    { id: 4, name: "Priya", course: "Civil" },
    { id: 5, name: "Arjun", course: "Information Technology" }
  ];

  const [students, setStudents] = useState(initialStudents);
  const [newStudent, setNewStudent] = useState({ id: "", name: "", course: "" });

  const handleChange = (e) => {
    setNewStudent({ ...newStudent, [e.target.name]: e.target.value });
  };

  const addStudent = () => {
    if (!newStudent.id || !newStudent.name || !newStudent.course) return;

    setStudents([...students, newStudent]);
    setNewStudent({ id: "", name: "", course: "" });
  };

  const deleteStudent = (id) => {
    const updated = students.filter((s) => s.id !== id);
    setStudents(updated);
  };

  return (
    <div className="container">
      <h2>Student Manager</h2>

      <div className="form">
        <input
          type="number"
          name="id"
          placeholder="ID"
          value={newStudent.id}
          onChange={handleChange}
        />
        <input
          type="text"
          name="name"
          placeholder="Name"
          value={newStudent.name}
          onChange={handleChange}
        />
        <input
          type="text"
          name="course"
          placeholder="Course"
          value={newStudent.course}
          onChange={handleChange}
        />

        <button onClick={addStudent}>Add Student</button>
      </div>

      {students.length === 0 ? (
        <p>No students available</p>
      ) : (
        <table>
          <thead>
            <tr>
              <th>ID</th>
              <th>Name</th>
              <th>Course</th>
              <th>Action</th>
            </tr>
          </thead>
          <tbody>
            {students.map((student) => (
              <tr key={student.id}>
                <td>{student.id}</td>
                <td>{student.name}</td>
                <td>{student.course}</td>
                <td>
                  <button
                    className="delete"
                    onClick={() => deleteStudent(student.id)}
                  >
                    Delete
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  );
}

export default StudentManager;
