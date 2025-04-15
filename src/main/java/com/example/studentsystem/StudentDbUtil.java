package com.example.studentsystem;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/// this is helper class tha that act with data base
public class StudentDbUtil {

    /**
     *
     */
    private  DataSource dataSource;
    public StudentDbUtil(DataSource dataSource) {
        this.dataSource = dataSource;
    }



    public List<Student> getAllStudents() throws Exception
    {
        List<Student> students = new ArrayList<Student>();
        Connection myconn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            myconn=dataSource.getConnection();
            // crate SQL statment
            String sql="select * from student order by first_name";
            stmt = myconn.createStatement();
            // execute quare
            rs = stmt.executeQuery(sql);
            //process the result set
            while (rs.next()) {
                /// retrieve  data from result est
                int id = rs.getInt("id");
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                String email = rs.getString("email");
                float Gpa = rs.getFloat("Gpa");
                /// create new student object
                Student tempStudnet=new Student(id,first_name,last_name,email,Gpa);
                /// add student to arraylist
                students.add(tempStudnet);
            }

        }
        finally {
            // close JDBC objects
            close(myconn, stmt, rs);
        }
        return students;
    }


    public void addstudnet(Student newstudent) throws Exception {
        /// create sql to insert student in data base
        Connection myconn=null;
        PreparedStatement mystat=null;
        try {
            /// get data base connection
            myconn=dataSource.getConnection();
            /// crate sql statment
            String sql="insert into student "+" (first_name,last_name,email,Gpa) "+ "values (?,?,?,?)";
            mystat=myconn.prepareStatement(sql);
            mystat.setString(1, newstudent.getFirstName());
            mystat.setString(2, newstudent.getLastName());
            mystat.setString(3, newstudent.getEmail());
            mystat.setFloat(4,newstudent.getGpa());
            mystat.execute();

        }finally {
            close(myconn,mystat,null);
        }

    }

    public Student getStudent(String theStudentId) throws Exception {

        Connection myconn=null;
        PreparedStatement mystat=null;
        ResultSet rs=null;
        Student theStudent=null;
        int studentId=Integer.parseInt(theStudentId);
        try {
            myconn=dataSource.getConnection();
            String Sql="select * from student where id=?";
            mystat=myconn.prepareStatement(Sql);
            mystat.setInt(1,studentId);
            rs=mystat.executeQuery();
            if(rs.next())
            {
                String first_name=rs.getString("first_name");
                String last_name=rs.getString("last_name");
                String email=rs.getString("email");
                float gpa=rs.getFloat("Gpa");
                /// crsate new student object
                theStudent=new Student(studentId,first_name,last_name,email,gpa);


            }
            else
                throw new SQLException("Could not find student id: "+studentId);
            /// return the student
            return theStudent;

        }finally {
            close(myconn,mystat,rs);
        }
    }

    public void updateStudent (Student updateStudent) throws SQLException {
        Connection myconn=null;
        PreparedStatement mystat=null;
        try {
            myconn = dataSource.getConnection();
            String Sql = "update student set first_name=?,last_name=?,email=?,Gpa=? where id=?";
            mystat = myconn.prepareStatement(Sql);
            mystat.setString(1, updateStudent.getFirstName());
            mystat.setString(2, updateStudent.getLastName());
            mystat.setString(3, updateStudent.getEmail());
            mystat.setFloat(4, updateStudent.getGpa());
            mystat.setInt(5, updateStudent.getId());
            mystat.execute();
        }

        finally {
            close(myconn,mystat,null);
        }
    }
    public void close(Connection myconn, Statement mystat, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (mystat != null) {
                mystat.close();
            }
            if (myconn != null) {
                myconn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(String studintId) throws Exception {
        /// casting the id to integer
        int id=Integer.parseInt(studintId);
        Connection myconn=null;
        PreparedStatement mystat=null;
        try  {
            myconn=dataSource.getConnection();
            String sql="delete from student where id=?";
            mystat=myconn.prepareStatement(sql);
            mystat.setInt(1,id);
            mystat.execute();
        }finally {
            close(myconn,mystat,null);
        }
    }
}
