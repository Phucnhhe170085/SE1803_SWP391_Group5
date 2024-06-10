package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Request;
import model.ReqType;
import model.RequestList;
import model.User;

public class RequestDAO extends DBContext {

    public List<ReqType> getAllReqType() {
        List<ReqType> requestTypes = new ArrayList<>();
        String sql = "SELECT * FROM requestType"; // Adjust based on your table structure
        try (
                PreparedStatement st = connection.prepareStatement(sql); ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("reqTypeId");
                String name = rs.getString("typeName");
                requestTypes.add(new ReqType(id, name));
            }
        } catch (SQLException e) {
            Logger.getLogger(RequestDAO.class.getName()).log(Level.SEVERE, "Failed to fetch request types", e);
        }
        return requestTypes;
    }

    public List<RequestList> getReqListByID(int userID) {
        List<RequestList> requests = new ArrayList<>();
        String sql = "SELECT u.userID, u.userName, r.title, r.description, rt.typeName, r.createAt, r.resStatus "
                + "FROM request r "
                + "JOIN [user] u ON r.renterID = u.userID "
                + "JOIN requestType rt ON r.requestType = rt.reqTypeID "
                + "WHERE u.userID = ?";
        try (
                PreparedStatement st = connection.prepareStatement(sql)) {
            // Set the parameter for the userID
            st.setInt(1, userID);
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    String userName = rs.getString("userName");
                    String title = rs.getString("title");
                    String description = rs.getString("description");
                    String typeName = rs.getString("typeName");
                    String createAt = rs.getString("createAt");
                    String resStatus = rs.getString("resStatus");

                    RequestList request = new RequestList(userName, title, description, typeName, createAt, resStatus);
                    requests.add(request);
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(RequestDAO.class.getName()).log(Level.SEVERE, "Failed to fetch requests", e);
        }
        return requests;
    }

    public List<RequestList> getReqList() {
        List<RequestList> requests = new ArrayList<>();
        String sql = "SELECT \n"
                + "    u.userName, r.title, r.description, rt.typeName, r.createAt, r.resStatus\n"
                + "FROM \n"
                + "    request r\n"
                + "JOIN \n"
                + "    [user] u ON r.renterID = u.userID\n"
                + "JOIN \n"
                + "    requestType rt ON r.requestType = rt.reqTypeID;";
        try (
                PreparedStatement st = connection.prepareStatement(sql); ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                String userName = rs.getString("userName");
                String title = rs.getString("title");
                String description = rs.getString("description");
                String typeName = rs.getString("typeName");
                String createAt = rs.getString("createAt");
                String resStatus = rs.getString("resStatus");

                RequestList request = new RequestList(userName, title, description, typeName, createAt, resStatus);
                requests.add(request);
            }
        } catch (SQLException e) {
            Logger.getLogger(RequestDAO.class.getName()).log(Level.SEVERE, "Failed to fetch requests", e);
        }
        return requests;
    }

    public boolean insertRequest(int renterID, int requestType, String title, String description, String createAt, String resStatus) {
        String sql = "INSERT INTO request (renterID, requestType, title, description, createAt, resStatus) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql);) {
            ps.setInt(1, renterID);
            ps.setInt(2, requestType);
            ps.setString(3, title);
            ps.setString(4, description);
            ps.setString(5, createAt);
            ps.setString(6, resStatus);

            int result = ps.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            Logger.getLogger(RequestDAO.class.getName()).log(Level.SEVERE, "Failed to insert request", e);
            return false;
        }
    }

    public static void main(String[] args) {

    RequestDAO dao = new RequestDAO();

    // Fetch and print request list for a specific userID
    int userID = 1;
    List<RequestList> requests = dao.getReqListByID(userID);
    if (requests.isEmpty()) {
        System.out.println("No requests found.");
    } else {
        System.out.println("Requests:");
        for (RequestList req : requests) {
            System.out.println(req);
        }
    }
}

//        RequestDAO dao = new RequestDAO();
//
//        // Fetch and print request list
//        List<RequestList> requests = dao.getReqList();
//        if (requests.isEmpty()) {
//            System.out.println("No requests found.");
//        } else {
//            System.out.println("Requests:");
//            for (RequestList req : requests) {
//                System.out.println(req);
//            }
//        }
//    }
//    public static void main(String[] args) {
//        RequestDAO dao = new RequestDAO();
//        List<ReqType> requestTypes = dao.getAllReqType();
//        if (requestTypes.isEmpty()) {
//            System.out.println("No request types found.");
//        } else {
//            System.out.println("Request Types:");
//            for (ReqType type : requestTypes) {
//                System.out.println("ID: " + type.getReqTypeId() + ", Name: " + type.getTypeName());
//            }
//        }
//
//        
//    }
}
