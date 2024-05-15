-- create database
create database if not exists Synthapix;

-- change to database
use Synthapix;

create table if not exists user
(
    id           bigint auto_increment comment 'id' primary key,
    userName     varchar(256)                           null comment '用户昵称',
    userAccount  varchar(256)                           not null comment '账号',
    userAvatar   varchar(1024)                          null comment '用户头像',
    gender       tinyint                                null comment '性别',
    userRole     varchar(256) default 'user'            not null comment '用户角色：user / admin',
    userPassword varchar(512)                           not null comment '密码',
    accessKey    varchar(512)                           not null comment 'access key',
    secretKey    varchar(512)                           not null comment 'secret key',
    createTime   datetime     default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime   datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete     tinyint      default 0                 not null comment '是否删除',
    constraint uni_userAccount
        unique (userAccount)
) comment '用户';


INSERT INTO user
(userName, userAccount, userAvatar, gender, userRole, userPassword, accessKey, secretKey, isDelete)
VALUES
    ('John Doe', 'johndoe123', 'http://example.com/avatar1.png', 1, 'user', 'password123', 'AK1234567890', 'SK1234567890', 0),
    ('Jane Smith', 'janesmith456', 'http://example.com/avatar2.png', 2, 'admin', 'password456', 'AK0987654321', 'SK0987654321', 0),
    ('Bob Johnson', 'bobjohn789', null, 1, 'user', 'password789', 'AK1122334455', 'SK1122334455', 0);


-- interface_info
create table if not exists Synthapix.`interface_info`
(
    `id` bigint not null auto_increment comment 'primary key' primary key,
    `name` varchar(256) not null comment 'name',
    `description` varchar(256) null comment 'description',
    `url` varchar(512) not null comment 'interface_url',
    `requestParams` text null comment 'requestParams',
    `requestHeader` text null comment 'request_reader',
    `responseHeader` text null comment 'responseHeader',
    `status` int default 0 not null comment 'status (0-close, 1-open)',
    `method` varchar(256) not null comment 'request method',
    `userId` bigint not null comment 'create userId',
    `createTime` datetime default CURRENT_TIMESTAMP not null comment 'create_time',
    `updateTime` datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment 'update_time',
    `isDelete` tinyint default 0 not null comment 'is_delete(0-not_deleted, 1- is_deleted)'
) comment 'interface_info';

INSERT INTO Synthapix.interface_info
(name, description, url, requestHeader, responseHeader, status, method, userId, isDelete)
VALUES
    ('User Data API', 'Retrieves user data based on user ID.', 'https://api.synthapix.com/user', '{"Content-Type": "application/json"}', '{"Content-Type": "application/json"}', 1, 'GET', 1, 0),
    ('Product Info API', 'Returns product information for a given product ID.', 'https://api.synthapix.com/product', '{"Content-Type": "application/json"}', '{"Content-Type": "application/json"}', 1, 'GET', 2, 0),
    ('Update User API', 'Updates user information for a given user ID.', 'https://api.synthapix.com/update_user', '{"Content-Type": "application/json", "Authorization": "Bearer token"}', '{"Content-Type": "application/json"}', 1, 'POST', 1, 0),
    ('Delete Product API', 'Deletes a product from the database.', 'https://api.synthapix.com/delete_product', '{"Content-Type": "application/json", "Authorization": "Bearer token"}', '{"Content-Type": "application/json"}', 0, 'DELETE', 2, 0),
    ('Weather API', 'Provides current weather information for a specified location.', 'https://api.synthapix.com/weather', '{"Content-Type": "application/json"}', '{"Content-Type": "application/json"}', 1, 'GET', 3, 0),
    ('Currency Converter API', 'Converts amount from one currency to another.', 'https://api.synthapix.com/currency_convert', '{"Content-Type": "application/json", "Authorization": "Bearer token"}', '{"Content-Type": "application/json"}', 1, 'POST', 4, 0),
    ('Login API', 'Authenticates users by login credentials.', 'https://api.synthapix.com/login', '{"Content-Type": "application/json"}', '{"Content-Type": "application/json"}', 1, 'POST', 5, 0),
    ('Logout API', 'Logs out a user from the system.', 'https://api.synthapix.com/logout', '{"Content-Type": "application/json"}', '{"Content-Type": "application/json"}', 1, 'POST', 5, 0),
    ('Item Listing API', 'Provides a list of items from the database.', 'https://api.synthapix.com/items', '{"Content-Type": "application/json"}', '{"Content-Type": "application/json"}', 1, 'GET', 6, 0),
    ('Item Details API', 'Provides detailed information about a single item.', 'https://api.synthapix.com/item/details', '{"Content-Type": "application/json"}', '{"Content-Type": "application/json"}', 1, 'GET', 6, 0),
    ('Add Item API', 'Adds a new item to the database.', 'https://api.synthapix.com/add/item', '{"Content-Type": "application/json"}', '{"Content-Type": "application/json"}', 1, 'POST', 6, 0),
    ('Update Item API', 'Updates existing item details.', 'https://api.synthapix.com/update/item', '{"Content-Type": "application/json"}', '{"Content-Type": "application/json"}', 1, 'PUT', 6, 0),
    ('Delete Item API', 'Removes an item from the database.', 'https://api.synthapix.com/delete/item', '{"Content-Type": "application/json"}', '{"Content-Type": "application/json"}', 0, 'DELETE', 6, 0),
    ('Create Report API', 'Generates a new report based on user input.', 'https://api.synthapix.com/create/report', '{"Content-Type": "application/json"}', '{"Content-Type": "application/json"}', 1, 'POST', 7, 0),
    ('Download Report API', 'Allows users to download a report.', 'https://api.synthapix.com/download/report', '{"Content-Type": "application/json"}', '{"Content-Type": "application/json"}', 1, 'GET', 7, 0),
    ('Upload Document API', 'Uploads a document to the server.', 'https://api.synthapix.com/upload/document', '{"Content-Type": "multipart/form-data"}', '{"Content-Type": "application/json"}', 1, 'POST', 8, 0),
    ('Profile Update API', 'Allows users to update their profile.', 'https://api.synthapix.com/update/profile', '{"Content-Type": "application/json"}', '{"Content-Type": "application/json"}', 1, 'PUT', 5, 0),
('Change Password API', 'Enables password changes for users.', 'https://api.synthapix.com/change/password', '{"Content-Type": "application/json"}', '{"Content-Type": "application/json"}', 1, 'POST', 5, 0),
('Reset Password API', 'Allows users to reset their password using email.', 'https://api.synthapix.com/reset/password', '{"Content-Type": "application/json"}', '{"Content-Type": "application/json"}', 1, 'POST', 5, 0),
('Search API', 'Performs a search based on user queries.', 'https://api.synthapix.com/search', '{"Content-Type": "application/json"}', '{"Content-Type": "application/json"}', 1, 'GET', 9, 0),
('Notification API', 'Handles sending notifications to users.', 'https://api.synthapix.com/notify', '{"Content-Type": "application/json"}', '{"Content-Type": "application/json"}', 1, 'POST', 10, 0),
('API Metrics API', 'Provides usage metrics for APIs.', 'https://api.synthapix.com/metrics', '{"Content-Type": "application/json"}', '{"Content-Type": "application/json"}', 1, 'GET', 11, 0),
('Comment API', 'Allows users to post comments.', 'https://api.synthapix.com/comment', '{"Content-Type": "application/json"}', '{"Content-Type": "application/json"}', 1, 'POST', 12, 0),
('Delete Comment API', 'Allows users to delete their comments.', 'https://api.synthapix.com/delete/comment', '{"Content-Type": "application/json"}', '{"Content-Type": "application/json"}', 0, 'DELETE', 12, 0),
('User Analytics API', 'Provides analytics about user engagement.', 'https://api.synthapix.com/user/analytics', '{"Content-Type": "application/json"}', '{"Content-Type": "application/json"}', 1, 'GET', 13, 0),
('Event Management API', 'Manages events within the platform.', 'https://api.synthapix.com/events', '{"Content-Type": "application/json"}', '{"Content-Type": "application/json"}', 1, 'POST', 14, 0);


create table if not exists Synthapix.`user_interface_info`
(
    `id` bigint not null auto_increment comment 'primary key' primary key,
    `userId` bigint not null comment 'User id',
    `interfaceInfoId` bigint not null comment 'interface id',
    `totalNum` int default 0 not null comment 'total call nums',
    `leftNum` int default 0 not null comment 'left call nums',
    `status` int default 0 not null comment '0-inactive, 1-active',
    `createTime` datetime default CURRENT_TIMESTAMP not null comment 'createTime',
    `updateTime` datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment 'updateTime',
    `isDelete` tinyint default 0 not null comment 'isDelete(0-not deleted, 1-deleted)'
) comment 'user_interface_info';
