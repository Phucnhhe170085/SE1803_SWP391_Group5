<%-- 
    Document   : formOwnerProfile
    Created on : 28 thg 5, 2024, 00:13:35
    Author     : quocp
--%>

<%@page import="dao.RoomDAO,java.util.List"%>
<%@page import="model.RoomDetailSe"%>
<%@ page import="java.text.DecimalFormat" %>

<% RoomDetailSe roomDetail = (RoomDetailSe) request.getAttribute("roomDetail"); 
   String[] listItemNames = (String[]) request.getAttribute("listItem");
   String error = (String) request.getAttribute("error");
%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="images/favicon.png">
        <link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css'>
        <title>Edit Owner Profile</title>

        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Work+Sans:wght@400;500;600;700&display=swap" rel="stylesheet">


        <script src='https://api.mapbox.com/mapbox-gl-js/v2.7.0/mapbox-gl.js'></script>
        <link href='https://api.mapbox.com/mapbox-gl-js/v2.7.0/mapbox-gl.css' rel='stylesheet' />

        <link rel="stylesheet" href="fonts/icomoon/style.css">
        <link rel="stylesheet" href="fonts/flaticon/font/flaticon.css">

        <link rel="stylesheet" href="css/tiny-slider.css">
        <link rel="stylesheet" href="css/aos.css">
        <link rel="stylesheet" href="css/style.css">

        <link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.min.css'>

        <style>
            #map {
                height: 400px;
                width: 100%;
            }
            body{
                background: #f7f7ff;
                margin-top:20px;
            }
            .card {
                position: relative;
                display: flex;
                flex-direction: column;
                min-width: 0;
                word-wrap: break-word;
                background-color: #fff;
                background-clip: border-box;
                border: 0 solid transparent;
                border-radius: .25rem;
                margin-bottom: 1.5rem;
                box-shadow: 0 2px 6px 0 rgb(218 218 253 / 65%), 0 2px 6px 0 rgb(206 206 238 / 54%);
            }
            .me-2 {
                margin-right: .5rem!important;
            }


            .file-input-wrapper {
                position: relative;
                overflow: hidden;
                display: inline-block;
                margin-top: 10px;
            }
            .file-input-wrapper input[type="file"] {
                position: absolute;
                top: 0;
                right: 0;
                margin: 0;
                padding: 0;
                font-size: 20px;
                cursor: pointer;
                opacity: 0;
                filter: alpha(opacity=0);
            }
            .file-input-wrapper button {
                background-color: #007bff;
                border: none;
                color: white;
                padding: 10px 20px;
                font-size: 16px;
                cursor: pointer;
                border-radius: 4px;
                font-weight: normal;
            }
            .file-input-wrapper button:hover {
                background-color: #0056b3;
            }
            .file-input-info {
                font-size: 14px;
                color: #6c757d;
                margin-top: 5px;
            }
            .error-message {
                color: red;
                margin-top: 5px;
                display: none;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="main-body">

                <div>
                    <nav class="site-nav" style="width: 73%">
                        <div class="container" >
                            <div class="menu-bg-wrap">
                                <div class="site-navigation">
                                    <a href="owner/OwnerProfile.jsp" class="logo m-0 float-start" style="text-decoration: none;">Edit Room</a>

                                    <jsp:include page="navbar.jsp"></jsp:include>

                                        <a href="#" class="burger light me-auto float-end mt-1 site-menu-toggle js-menu-toggle d-inline-block d-lg-none" data-toggle="collapse" data-target="#main-navbar">
                                            <span></span>
                                        </a>

                                    </div>
                                </div>
                            </div>
                        </nav>
                    </div>

                    <div class="row" style="margin-top: 120px;">
                        <div class="col-lg-4 anhdaden">
                            <div class="card">                                
                                <div class="card-body">
                                    <div style="padding-left: 120px; font-size: 19px; font-weight: 700">Location</div>
                                    <hr class="my-4">                                   
                                    <div id='map'></div>
                                    <script>
                                        mapboxgl.accessToken = 'pk.eyJ1IjoidGFvbGFhbiIsImEiOiJjbHhnNGxhY2swcHpiMmpyMnN6ZDhzcHQxIn0.U__4wJQWZALurj5uvyDqkw';

                                        var map = new mapboxgl.Map({
                                            container: 'map',
                                            style: 'mapbox://styles/mapbox/streets-v11',
                                            center: [105.535188, 21.009687],
                                            zoom: 16
                                        });

                                        new mapboxgl.Marker()
                                                .setLngLat([105.535188, 21.009687])
                                                .addTo(map);
                                    </script>
                                </div>
                            </div>
                        </div>

                        <div class="col-lg-8">                       
                            <div class="card">
                            <% if (error != null) { %>
                            <p style="margin: 0px; text-align: center; color: red; margin: 10px 0px; background: beige"><%= error %></p>
                            <%}%>
                            <form action="OwnerController" method="post" enctype="multipart/form-data">
                                <div class="card-body">                                    
                                    <div class="row mb-3">
                                        <div class="col-sm-3">
                                            <h6 class="mb-0">Room Number</h6>
                                        </div>
                                        <div class="col-sm-9 text-secondary">
                                            <input type="text" class="form-control" name="roomNumber" value="<%= roomDetail.getRoomNumber()%>">
                                        </div>
                                    </div>                              
                                    <div class="row mb-3">
                                        <div class="col-sm-3">
                                            <h6 class="mb-0">Room Fee</h6>
                                        </div>
                                        <div class="col-sm-9 text-secondary">
                                            <%
                                                DecimalFormat df = new DecimalFormat("#.##");
                                                String formattedFee = df.format(roomDetail.getRoomFee());
                                            %>
                                            <input type="text" class="form-control" name="roomFee" value="<%= formattedFee %>">
                                        </div>
                                    </div>
                                    <div class="row mb-3">
                                        <div class="col-sm-3">
                                            <h6 class="mb-0">Room Size</h6>
                                        </div>
                                        <div class="col-sm-9 text-secondary">
                                            <input type="text" class="form-control" name="roomSize" value="<%= roomDetail.getRoomSize()%>">
                                        </div>
                                    </div>
                                    <div class="row mb-3">
                                        <div class="col-sm-3">
                                            <h6 class="mb-0">Room Image</h6>
                                        </div>
                                        <div class="col-sm-9 text-secondary">                                           
                                            <input type="file" class="form-control" name="roomImg" value="<%= roomDetail.getRoomImg()%>" required="" >
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <h6 class="mb-0" style="padding-left: 220px; padding-bottom: 20px; padding-top: 10px; font-weight: 800">Items in the rooom</h6>
                                        <table id="itemTable" class="table table-bordered">
                                            <thead>
                                                <tr>
                                                    <th>Item</th>
                                                    <th>Quantity</th>
                                                    <th>Action</th>
                                                </tr>
                                            </thead>
                                            <tbody>                       
                                                <%
                                                    if (roomDetail.getItemName() != null) {
                                                    String[] itemNames = roomDetail.getItemName();
                                                    int[] quantities = roomDetail.getQuantity();
                                                    int[] itemIDs = roomDetail.getItemID();
                                                    int roomID_updateItem = roomDetail.getRoomID();
                                                    if (itemNames != null && quantities != null && itemNames.length == quantities.length) {
                                                        for (int i = 0; i < itemNames.length; i++) {
                                                            String itemName = itemNames[i];
                                                            int quantity = quantities[i];
                                                            int itemID = itemIDs[i];
                                                %>
                                                <tr data-itemid="<%= itemID %>">
                                                    <td><input type="text" class="form-control" name="itemNames" value="<%= itemName %>" readonly="" ></td>
                                                    <td><input type="text" class="form-control" name="quantities" value="<%= quantity %>" ></td>
                                            <input type="hidden" name="roomID_updateItem" value="<%= roomID_updateItem %>"> 
                                            <td>
                                                <a href="OwnerController?service=deleteItem&itemID=<%= itemID%>&roomID=<%= roomDetail.getRoomID()%>" class="btn btn-danger">Delete</a>
                                            </td>
                                            </tr>
                                            <% 
                                                    }
                                                }
                                            }
                                            %>
                                            </tbody>
                                        </table>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-2"></div>
                                        <div class="col-sm-10 text-secondary">
                                            <button type="button" id="updateButton" class="btn btn-success" onclick="updateRoomItems()">Update Room Item</button>
                                            <a href="#" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#addItemModal">Add Room Item</a>
                                            <input type="submit" class="btn btn-primary px-4" value="Save Changes">                                           
                                        </div>
                                    </div>
                                    <input type="hidden" name="roomID" value="<%= roomDetail.getRoomID()%>">
                                    <input type="hidden" class="btn btn-primary px-4" name="service" value="updateRoomDetail">
                                </div>               
                            </form>         
                            <div class="modal fade" id="addItemModal" tabindex="-1" aria-labelledby="addItemModalLabel" aria-hidden="true">
                                <div class="modal-dialog modal-dialog-centered">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="addItemModalLabel">Add Room Item</h5>
                                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                        </div>
                                        <div class="modal-body">                                                    
                                            <form id="addItemFormModal" action="OwnerController" method="get" enctype="multipart/form-data">
                                                <div class="mb-3">
                                                    <label for="itemNameModal" class="form-label">Item Name</label>
                                                    <select class="form-control" id="itemNameModal" name="itemName">
                                                        <% 
                                                            for (int i = 0; i < listItemNames.length; i++) { 
                                                            String itemName = listItemNames[i];
                                                        %>
                                                        <option><%= itemName %></option>
                                                        <% } %>
                                                    </select>
                                                </div>
                                                <div class="mb-3">
                                                    <label for="newQuantityModal" class="form-label">Quantity</label>
                                                    <input type="text" class="form-control" id="newQuantityModal" name="quantity">
                                                </div>
                                                <input type="hidden" name="service" value="addItem">
                                                <input type="hidden" name="roomID" value="<%= roomDetail.getRoomID()%>">
                                                <button type="button" class="btn btn-primary" id="btnSubmitNewItemModal">Add Item</button>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div> 
                        </div>
                    </div>                                              
                </div>
            </div>
        </div>
    </div>
</div>

<script src='https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/js/bootstrap.bundle.min.js'></script>
<script src="js/bootstrap.bundle.min.js"></script>
<script src="js/tiny-slider.js"></script>
<script src="js/aos.js"></script>
<script src="js/navbar.js"></script>
<script src="js/counter.js"></script>
<script src="js/custom.js"></script>     
<script>
                                                document.getElementById('btnSubmitNewItemModal').addEventListener('click', function () {
                                                    var quantityInput = document.getElementById('newQuantityModal').value;
                                                    var quantity = parseFloat(quantityInput);

                                                    if (!Number.isInteger(quantity) || quantity <= 0) {
                                                        alert('Quantity is not valid. Please enter a positive integer');
                                                    } else {
                                                        var form = document.getElementById('addItemFormModal');
                                                        form.submit();
                                                    }
                                                });
</script>

<script>
    let isUpdating = false;
    function updateRoomItems() {

        if (isUpdating) {
            return;
        }

        isUpdating = true;

        console.log("Update Room Items button clicked.");
        const rows = document.querySelectorAll("#itemTable tbody tr");
        const updatedItems = [];
        const roomID_updateItem = document.querySelector('input[name="roomID_updateItem"]').value;
        let hasInvalidQuantity = false;

        rows.forEach(row => {
            const itemNameInput = row.querySelector('input[name="itemNames"]');
            const quantityInput = row.querySelector('input[name="quantities"]');

            if (itemNameInput && quantityInput) {
                const itemName = itemNameInput.value;
                const quantity = quantityInput.value;
                const itemID = row.getAttribute("data-itemid");

                if (quantity < 0) {
                    hasInvalidQuantity = true;
                    alert("Quantity cannot be less than 0 for item: " + itemName);
                    return;
                }

                updatedItems.push({itemID: itemID, itemName: itemName, quantity: quantity, roomID: roomID_updateItem});
            }
        });

        if (hasInvalidQuantity) {
            isUpdating = false;
            return;
        }

        console.log("Updated items: ", updatedItems);



        const xhr = new XMLHttpRequest();
        xhr.open("POST", "OwnerController?service=updateRoomItem", true);
        xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4) {
                if (xhr.status === 200) {
                    console.log("Room items updated successfully!");
                    window.location.href = "OwnerController?service=updateRoomItem";
                } else {
                    console.log("Error: " + xhr.status);
                }
            }
        };
        xhr.send(JSON.stringify(updatedItems));
    }
</script>

</body>
</html>
