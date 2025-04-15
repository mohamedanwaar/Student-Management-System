package com.example.studentsystem;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentControllerServlet", value = "/StudentControllerServlet")
public class StudentControllerServlet extends HttpServlet

{

    @Resource(name = "jdbc/web_student_tracker")
    private DataSource dataSource;
    private StudentDbUtil studentDbUtil;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init();
        /// create  our student database ... and pass  in the connection pool/ dataSource
        try {
            studentDbUtil = new StudentDbUtil( dataSource);
        }
        catch (Exception e) {
            throw new ServletException(e);
        }
    }



    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        try {
            // this paramter is decide is the request come from add student page
            String theCommand=request.getParameter("command");   // this is hidden bottom in AddStudentForm.html
            if(theCommand==null)
            {
                // if the page is to list student we set thecommand to LISt
                theCommand="LIST";
            }
            switch (theCommand){
                case "LIST":
                    listStudents(request,response);
                    break;
                case "ADD":
                    addStudent(request,response);
                    break;
                case "LOAD":
                    Loadstudent(request,response);
                    break;
                case "UPDATE":
                    // update student
                    updateStudent(request,response);
                    break;
                case "DELETE":

                    deletestudnet(request,response);
                    break;
                default:
                    listStudents(request,response);
                    break;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void deletestudnet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        /// this is used to remove studnet from the database
        /// get the id of student
        String studintId=request.getParameter("studentId");
        /// delete student from the database
        studentDbUtil.deleteStudent(studintId);
        /// send them to list studnet
        listStudents(request,response);
    }

    private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //this is used to update student in the database
        // get the attribute for the form
        int id=Integer.parseInt(request.getParameter("studentId")); /// casting the id to integer
        String firstName=request.getParameter("firstName");
        String lastname=request.getParameter("lastName");
        String email=request.getParameter("email");
        float gpa= Float.parseFloat(request.getParameter("gpa"));

        // Validate input
        if (firstName == null || firstName.trim().isEmpty() || !firstName.matches("[A-Za-z\\s]+")) {
            request.setAttribute("errorMessage", "Invalid first name. Only letters and spaces are allowed.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/update-student-form.jsp");
            Loadstudent(request, response); // Load the student data again for correction
            dispatcher.forward(request, response);
            return;

        }
        if (lastname == null || lastname.trim().isEmpty() || !lastname.matches("[A-Za-z\\s]+")) {
            request.setAttribute("errorMessage", "Invalid last name. Only letters and spaces are allowed.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/update-student-form.jsp");
            Loadstudent(request, response); // Load the student data again for correction
            dispatcher.forward(request, response);

            return;

        }
        if (email == null || email.trim().isEmpty() || !email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
            request.setAttribute("errorMessage", "Invalid email format.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/update-student-form.jsp");
            Loadstudent(request, response); // Load the student data again for correction
            dispatcher.forward(request, response);
            return;


        }

        try {

            if (gpa < 0 || gpa > 4) {
                request.setAttribute("errorMessage", "GPA must be between 0 and 4.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/update-student-form.jsp");
                Loadstudent(request, response); // Load the student data again for correction
                dispatcher.forward(request, response);
                return;


            }
        } catch (NumberFormatException e) {
            request.setAttribute("errorMessage", "Invalid GPA format.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/update-student-form.jsp");
            Loadstudent(request, response); // Load the student data again for correction
            dispatcher.forward(request, response);
            return;
        }
        /// create object of student class
        Student UpdateStudent=new Student(id,firstName,lastname,email,gpa);
        studentDbUtil.updateStudent(UpdateStudent);
        /// send them to list studnet
        listStudents(request,response);



    }

    private void Loadstudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // this is used to load student database by id

        /// read id from the form data
        String theStudentId=request.getParameter("studentId");

        /// get student from database
        Student theStudent=studentDbUtil.getStudent(theStudentId);

        /// place student in the request attribute
        request.setAttribute("THE_STUDENT",theStudent);
        /// send to JSP page
        RequestDispatcher dispatcher=request.getRequestDispatcher("/update-student-form.jsp");
        dispatcher.forward(request,response);
    }

    private void addStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //
        // get the attribute for the form
        String firstName=request.getParameter("firstName");
        String lastName=request.getParameter("lastName");
        String email=request.getParameter("email");
        float gpa= Float.parseFloat(request.getParameter("gpa"));
        // Validate input
        if (firstName == null || firstName.trim().isEmpty() || !firstName.matches("[A-Za-z\\s]+")) {
            request.setAttribute("errorMessage", "Invalid last name. Only letters and spaces are allowed.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/AddStudnetForm.jsp");
            dispatcher.forward(request, response);
            addStudent(request, response); // Load the student data again for correction
            return;

        }
        if (lastName == null || lastName.trim().isEmpty() || !lastName.matches("[A-Za-z\\s]+")) {
            request.setAttribute("errorMessage", "Invalid last name. Only letters and spaces are allowed.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/AddStudnetForm.jsp");
            dispatcher.forward(request, response);

            return;

        }
        if (email == null || email.trim().isEmpty() || !email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
            request.setAttribute("errorMessage", "Invalid email format.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/AddStudnetForm.jsp");
            dispatcher.forward(request, response);
            return;

        }

        try {

            if (gpa < 0 || gpa > 4) {
                request.setAttribute("errorMessage", "GPA must be between 0 and 4.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/AddStudnetForm.jsp");
                dispatcher.forward(request, response);
                return;


            }
        } catch (NumberFormatException e) {
            request.setAttribute("errorMessage", "Invalid GPA format.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/AddStudnetForm.jsp");
            dispatcher.forward(request, response);
            return;
        }

       // crate new student object
        Student newstudent=new Student(firstName,lastName,email,gpa);
        /// add student to database
        studentDbUtil.addstudnet(newstudent);
        /// send them to list studnet
        listStudents(request,response);

    }

    private void listStudents(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // get all student from database
        List <Student> students=studentDbUtil.getAllStudents();
        //add student to the request
        request.setAttribute("STUDENT_LIST", students);
        RequestDispatcher dispatcher=request.getRequestDispatcher("/studentsView.jsp");
        dispatcher.forward(request,response);
    }
}
