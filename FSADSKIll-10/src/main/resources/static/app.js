const { useState } = React;

function StudentManager() {
  const initialStudents = [
    { id: 1, name: 'John Doe', course: 'Computer Science' },
    { id: 2, name: 'Jane Smith', course: 'Data Science' },
    { id: 3, name: 'Mike Johnson', course: 'Web Development' },
    { id: 4, name: 'Sarah Wilson', course: 'AI & ML' },
    { id: 5, name: 'David Brown', course: 'Cyber Security' }
  ];

  const [students, setStudents] = useState(initialStudents);
  const [newStudent, setNewStudent] = useState({ id: '', name: '', course: '' });

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setNewStudent(prev => ({ ...prev, [name]: value }));
  };

  const handleAddStudent = (e) => {
    e.preventDefault();
    if (newStudent.id && newStudent.name && newStudent.course) {
      setStudents(prev => [...prev, { ...newStudent, id: Number(newStudent.id) }]);
      setNewStudent({ id: '', name: '', course: '' });
    }
  };

  const handleDeleteStudent = (id) => {
    setStudents(prev => prev.filter(student => student.id !== id));
  };

  return (
    <div className="student-manager">
      <h2>Student Management Portal</h2>

      <form onSubmit={handleAddStudent} className="add-student-form">
        <input
          type="number"
          name="id"
          placeholder="Student ID"
          value={newStudent.id}
          onChange={handleInputChange}
          required
        />
        <input
          type="text"
          name="name"
          placeholder="Student Name"
          value={newStudent.name}
          onChange={handleInputChange}
          required
        />
        <input
          type="text"
          name="course"
          placeholder="Course"
          value={newStudent.course}
          onChange={handleInputChange}
          required
        />
        <button type="submit">Add Student</button>
      </form>

      <div className="students-section">
        <h3>Students List</h3>
        {students.length === 0 ? (
          <p className="no-students">No students available</p>
        ) : (
          <table className="students-table">
            <thead>
              <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Course</th>
                <th>Action</th>
              </tr>
            </thead>
            <tbody>
              {students.map(student => (
                <tr key={student.id}>
                  <td>{student.id}</td>
                  <td>{student.name}</td>
                  <td>{student.course}</td>
                  <td>
                    <button
                      className="delete-btn"
                      onClick={() => handleDeleteStudent(student.id)}
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
    </div>
  );
}

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(<StudentManager />);