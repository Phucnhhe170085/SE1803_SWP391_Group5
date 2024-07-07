package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ReqType;
import model.Request;
import model.RequestList;

public class RequestDAO extends DBContext {

    public List<ReqType> getAllReqType() {
        List<ReqType> requestTypes = new ArrayList<>();
        String sql = "SELECT * FROM requestType"; // Adjust based on your table structure
        try (
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery()
        ) {
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
        String sql = "SELECT u.userID, u.userName, r.requestID, r.title, r.description, rt.typeName, r.createAt, r.resStatus "
                + "FROM request r "
                + "JOIN [user] u ON r.renterID = u.userID "
                + "JOIN requestType rt ON r.requestType = rt.reqTypeID "
                + "WHERE u.userID = ?";
        try (
            PreparedStatement st = connection.prepareStatement(sql)
        ) {
            st.setInt(1, userID);
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                                       
                    int requestID = rs.getInt("requestID");
                    int uID = rs.getInt("userID");
                    String userName = rs.getString("userName");
                    String title = rs.getString("title");
                    String description = rs.getString("description");
                    String typeName = rs.getString("typeName");
                    String createAt = rs.getString("createAt");
                    String resStatus = rs.getString("resStatus");

                    RequestList request = new RequestList(requestID, uID, userName, title, description, typeName, createAt, resStatus);
                    requests.add(request);
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(RequestDAO.class.getName()).log(Level.SEVERE, "Failed to fetch requests", e);
        }
        return requests;
    }
        
    
    public List<RequestList> getAllRequest() {
    List<RequestList> requests = new ArrayList<>();
    String sql = "SELECT u.userID, u.userName, r.requestID, r.title, r.description, rt.typeName, r.createAt, r.resStatus "
               + "FROM request r "
               + "JOIN [user] u ON r.renterID = u.userID "
               + "JOIN requestType rt ON r.requestType = rt.reqTypeID";
    
    try (PreparedStatement st = connection.prepareStatement(sql);
         ResultSet rs = st.executeQuery()) {
        
        while (rs.next()) {
            int requestID = rs.getInt("requestID");
            int uID = rs.getInt("userID");
            String userName = rs.getString("userName");
            String title = rs.getString("title");
            String description = rs.getString("description");
            String typeName = rs.getString("typeName");
            String createAt = rs.getString("createAt");
            String resStatus = rs.getString("resStatus");

            RequestList request = new RequestList(requestID, uID, userName, title, description, typeName, createAt, resStatus);
            requests.add(request);
        }
    } catch (SQLException e) {
        Logger.getLogger(RequestDAO.class.getName()).log(Level.SEVERE, "Failed to fetch all requests", e);
    }
    
    return requests;
}


    public boolean insertRequest(int renterID, int requestType, String title, String description, String createAt, String resStatus) {
        String sql = "INSERT INTO request (renterID, requestType, title, description, createAt, resStatus) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
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

    public boolean updateRequest(int requestID, int renterID, int requestType, String title, String description, String createAt, String resStatus) {
        String sql = "UPDATE request SET renterID = ?, requestType = ?, title = ?, description = ?, createAt = ?, resStatus = ? WHERE requestID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, renterID);
            ps.setInt(2, requestType);
            ps.setString(3, title);
            ps.setString(4, description);
            ps.setString(5, createAt);
            ps.setString(6, resStatus);
            ps.setInt(7, requestID);

            int result = ps.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            Logger.getLogger(RequestDAO.class.getName()).log(Level.SEVERE, "Failed to update request", e);
            return false;
        }
    }

    public boolean deleteRequest(int requestID) {
        String sql = "DELETE FROM request WHERE requestID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, requestID);

            int result = ps.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            Logger.getLogger(RequestDAO.class.getName()).log(Level.SEVERE, "Failed to delete request", e);
            return false;
        }
    }

    public RequestList getRequestByID(int requestID) {
        RequestList request = null;
        String sql = "SELECT u.userName, r.title, r.description, rt.typeName, r.createAt, r.resStatus "
                + "FROM request r "
                + "JOIN [user] u ON r.renterID = u.userID "
                + "JOIN requestType rt ON r.requestType = rt.reqTypeID "
                + "WHERE r.requestID = ?";
        try (
            PreparedStatement st = connection.prepareStatement(sql)
        ) {
            st.setInt(1, requestID);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    String userName = rs.getString("userName");
                    String title = rs.getString("title");
                    String description = rs.getString("description");
                    String typeName = rs.getString("typeName");
                    String createAt = rs.getString("createAt");
                    String resStatus = rs.getString("resStatus");

                    request = new RequestList(userName, title, description, typeName, createAt, resStatus);
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(RequestDAO.class.getName()).log(Level.SEVERE, "Failed to fetch request by ID", e);
        }
        return request;
    }
     public void updateRequestStatus(String status, int requestId) {
        String sql = "UPDATE request SET resStatus = ? WHERE requestID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, status);
            ps.setInt(2, requestId);
            ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(RequestDAO.class.getName()).log(Level.SEVERE, "Failed to update request status", e);
        }
    }
     
        public static void main(String[] args) {
        RequestDAO dao = new RequestDAO();
        dao.updateRequestStatus( "Denied", 309);
    }
     
//    public static void main(String[] args) {
//    // Example usage to test updateRequest method
//        RequestDAO requestDAO = new RequestDAO();
//        
//        // Fetch all requests
//        List<RequestList> list = requestDAO.getAllRequest();
//        
//        // Print all requests to verify fetching
//        System.out.println("Current requests:");
//        for (RequestList request : list) {
//            System.out.println(request);
//        }
//
//    }
//    public static void main(String[] args) {
//        // Example usage to test updateRequest method
//        RequestDAO requestDAO = new RequestDAO();
//
//        // Example values (replace with your actual test values)
//        int requestID = 309;
//        int renterID = 1;
//        int requestType = 1;
//        String title = "BCD";
//        String description = "BCD";
//        String createAt = "2024-06-15 10:00:00"; // Example timestamp
//        String resStatus = "Pending"; // Example status
//
//        boolean updateSuccess = requestDAO.updateRequest(requestID, renterID, requestType, title, description, createAt, resStatus);
//
//        if (updateSuccess) {
//            System.out.println("Request updated successfully.");
//        } else {
//            System.out.println("Failed to update request.");
//        }
//    }

   
}
