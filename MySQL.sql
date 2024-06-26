CREATE TABLE `productmovie`.`phim` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `ten` TEXT NOT NULL,
  `hinhanh` TEXT NOT NULL,
  `daodien` TEXT NOT NULL,
  `dienvien` TEXT NOT NULL,
  `thoiluong` TEXT NOT NULL,
  `ngonngu` TEXT NOT NULL,
  `theloaiid` INT NOT NULL,
  `mota` TEXT NOT NULL,
  PRIMARY KEY (`id`));
  
INSERT INTO phim VALUES ('1', 'Garfield: Mèo Béo Siêu Quậy', 'https://files.betacorp.vn/media%2fimages%2f2024%2f05%2f28%2f310524%2Dgarfield%2D150640%2D280524%2D95.jpg', 'Mark Dindal', 'Chris Pratt, Samuel L. Jackson, Nicholas Hoult', '101', 'Tiếng Việt', '1', 'Trong bộ phim hoạt hình này, chú mèo mê đồ ăn Garfield bị cuốn vào một vụ trộm để giúp cha mình - một tên trộm đường phố, khỏi một chú mèo biểu diễn khác đang muốn trả thù ông. Bắt đầu như một mối quan hệ hợp tác miễn cưỡng và kết thúc bằng việc Garfield và Vic nhận ra rằng cha con họ không hề khác biệt như vẻ ngoài của mình.');
INSERT INTO phim VALUES ('2', 'Doraemon: Nobita và Bản Giao Hưởng Địa Cầu', 'https://files.betacorp.vn/media%2fimages%2f2024%2f04%2f24%2f240524%2Ddraft%2Ddoraemon%2D170958%2D240424%2D90.png', 'Kazuaki Imai', 'Wasabi Mizuta, Megumi Ôhara, Yumi Kakazu', '115', 'Tiếng', '1', 'Đôrêmon và những người bạn thực hiện chuyến phiêu lưu để gặp gỡ những người bạn mới, kết nối mọi người bằng âm nhạc và cứu thế giới khỏi khủng hoảng. Liệu những người bạn nhỏ có thể cứu được "tương lai âm nhạc" và cả địa cầu này?');
INSERT INTO phim VALUES ('3', 'Ngôi Đền Kỳ Quái 4', 'https://files.betacorp.vn/media%2fimages%2f2024%2f05%2f27%2f400x633%2D7%2D151139%2D270524%2D46.jpg', 'Phontharis Chotkijsadarsopon', 'Witthawat Rattanaboonbaramee, Bhuripat Vejvongsatechawat, Phiravich Attachitsataporn', '111', 'Tiếng Thái', '16', 'Min Joon bị de dọa bởi một linh hồn Pee Nak bí ẩn và phải thực hiện lời hứa trong quá khứ của mình. Nếu không hoàn thành lời hứa ấy, những tội lỗi mà anh từng gây nên sẽ quay trở lại nguyên rủa và trừng phạt cuộc đời anh.');
INSERT INTO phim VALUES ('4', 'Totto-Chan: Cô Bé Bên Cửa Sổ', 'https://files.betacorp.vn/media%2fimages%2f2024%2f05%2f20%2ftotto%2Dchan%2Dteaser%2Dposter%2Dkt%2Dfacebook%2Ddkkc%2D31%2D05%2D2024%2D162320%2D200524%2D80.jpg', 'Shinnosuke Yakuwa', 'Liliana Ohno, Koji Yakusho, Shun Oguri, Anne Watanabe, Karen Takizawa', '114', 'Tiếng Việt', '1', 'Sau khi không phù hợp với trường tiểu học ban đầu, Totto Chan đi học tại Tomoe Gakuen. Tại đây, cô gặp những học sinh đặc biệt và học được những điều mới mẻ, ngay cả khi Nhật Bản rơi vào chiến tranh.');
INSERT INTO phim VALUES ('5', 'Furiosa: Câu Chuyện Từ Max Điên', 'https://files.betacorp.vn/media%2fimages%2f2024%2f05%2f24%2f400x633%2D6%2D103906%2D240524%2D41.jpg', 'George Miller', 'Anya Taylor-Joy, Chris Hemsworth, Alyla Brown, Tom Burke', '148', 'Tiếng Anh', '18', 'Fury Road, câu chuyện kể về thời trẻ của nữ chiến binh Furiosa khi cô bị tách ra khỏi nơi ẩn náu ở Green Place of Many Mothers và lần đầu tiên buộc phải đối mặt với sự điên rồ của thế giới bên ngoài. Nhưng cô ấy luôn nuôi trong mình một khát vọng “trở về đất mẹ” mãnh liệt.');
INSERT INTO phim VALUES ('6', 'Gia Tài Của Ngoại', 'https://files.betacorp.vn/media%2fimages%2f2024%2f06%2f03%2f400x633%2D141654%2D030624%2D92.jpg', 'Pat Boonnitipat', 'Putthipong Assaratanakul, Usha Seamkhum, Tontawan Tantivejakul', '127', 'Tiếng Việt', '13', 'Gia Tài Của Ngoại xoay quanh câu chuyện về M (do Billkin Putthipong thủ vai) là một chàng trai thất nghiệp và đang tìm mọi cách để làm giàu. Một ngày nọ, M nhận ra có một cách làm giàu nhanh chóng: chăm sóc người bà đang mắc ung thư giai đoạn cuối để lấy tài sản thừa kế. Vì vậy, M quyết định đến chăm sóc người bà của mình. Tuy nhiên, trong khoảng thời gian sống cùng bà, M đã nhận ra những điều còn giá trị hơn cả tài sản.');
INSERT INTO phim VALUES ('7', 'Lật Mặt 7', 'https://files.betacorp.vn/media%2fimages%2f2024%2f04%2f19%2flm7400wx633h%2D181042%2D190424%2D36.jpg', 'Lý Hải', 'Thanh Hiền, Trương Minh Cường, Đinh Y Nhung, Quách Ngọc Tuyên, Trâm Anh, Trần Kim Hải,..', '138', 'Tiếng Việt', '16', 'Qua những lát cắt đan xen, ẩn chứa nhiều nụ cười và cả nước mắt, "Lật Mặt 7: Một Điều Ước" là câu chuyện cảm động về đại gia đình bà Hai 73 tuổi - người mẹ đơn thân tự mình nuôi 5 người con khôn lớn. Khi trưởng thành, mỗi người đều có cuộc sống và gia đình riêng. Bất chợt, biến cố ập đến, những góc khuất dần được hé lộ, những nỗi niềm, lo lắng, trĩu nặng ẩn sâu trong trái tim người mẹ. Trách nhiệm thuộc về ai?');
INSERT INTO phim VALUES ('8', 'Móng Vuốt', 'https://files.betacorp.vn/media%2fimages%2f2024%2f05%2f28%2f070624%2Dsneak%2Dmong%2Dvuot%2D150957%2D280524%2D53.jpg', 'Lê Thanh Sơn', 'Tuấn Trần, Thảo Tâm, Rocker Nguyễn, Gi A Nguyễn, Quốc Khánh, Naomi, Ceri, Hồng Thanh', '96', 'Tiếng Việt', '16', 'Móng Vuốt dẫn dắt câu chuyện đi từ buổi tiệc dã ngoại náo nhiệt của một nhóm bạn đến một kết cục kinh hoàng khi phải đấu tranh sinh tồn với một con ác thú.');
INSERT INTO phim VALUES ('9', 'Những Gã Trai Hư: Chơi Hay Bị Xơi', 'https://files.betacorp.vn/media%2fimages%2f2024%2f05%2f28%2fbad%2Dboys%2Dride%2Dor%2Ddie%2D2024%2Dposter%2D132916%2D280524%2D85.jpg', 'Adil El Arbi, Bilall Fallah', 'Will Smith, Martin Lawrence, Vanessa Hudgens', '115 ', 'Tiếng Anh', '18', 'Mùa hè này, Bad Boys được yêu thích trên toàn thế giới đã trở lại với sự kết hợp mang tính biểu tượng giữa hành động ngay tại chỗ và bộ phim hài kịch nhưng lần này có một sự thay đổi: những bộ phim hay nhất của Miami hiện đang trên đường chạy trốn.');
INSERT INTO phim VALUES ('10', 'Stalker: Tội Ác Hoàn Hảo', 'https://files.betacorp.vn/media%2fimages%2f2024%2f05%2f31%2f310524%2Dtoi%2Dac%2Dhoan%2Dhao%2D151038%2D310524%2D37.jpg', 'Kim Sehwi', 'Byun Yo-han, Shin Hye-sun, Lee El', '103 ', 'Tiếng Hàn', '16', 'Lợi dụng công việc môi giới bất động sản của mình, Koo Jung-tae thường xuyên đột nhập vào những căn nhà bằng chìa khoá được khách hàng giao để thoả mãn sở thích rình rập và trộm các món đồ không cần thiết. Mọi rắc rối bắt đầu khi anh bí mật theo dõi cuộc sống của Han Sora - cô gái xinh đẹp, nổi tiếng trên mạng xã hội. Đến một ngày, Han Sora trở thành khách hàng của văn phòng môi giới bất động sản mà Koo Jung-tae làm việc. Có được chìa khoá căn hộ của Han Sora, theo “thói quen”, Koo Jung-tae lẻn vào nhà và bất ngờ chứng kiến cảnh Han Sora chết trên sofa.');
INSERT INTO phim VALUES ('11', 'Đừng Mở Cửa', 'https://files.betacorp.vn/media%2fimages%2f2024%2f05%2f29%2f400x633%2D3%2D171906%2D290524%2D35.jpg', 'Banmei Takahashi', 'Soon', '92 ', 'Tiếng Nhật', '18', 'Yasuko, một phụ nữ nội trợ, sống cùng chồng và con trai tại một căn chung cư. Bực mình vì những cuộc gọi rác và nhân viên bán hàng gõ của tận nhà, Yasuko đã đóng gói mạnh cửa vào ngón tay của một nam nhân viên bán hàng khi anh ta cố cày cú rơi qua cánh cửa bị khóa, cơn ác mộng của cô bắt đầu.');
INSERT INTO phim VALUES ('12', 'Bẫy Nuốt Mạng', 'https://files.betacorp.vn/media%2fimages%2f2024%2f06%2f04%2fthe%2Dplot%2Dteaser%2Dposter%2D135321%2D040624%2D17.jpg', 'Lee Yo-sup', 'Gang Dong-won, Lee Moo-saeng, Lee Hyun-wook, Lee Mi-sook, Tang Jun-sang, Kim Hong-pa, Jung Eun-chae,...', '120 ', 'Tiếng Hàn', '18', 'Phim mở màn với loạt sự cố chết người gây xôn xao dư luận Hàn Quốc, tuy nhiên, sự thật đằng sau những tai nạn ngẫu nhiên này là một cái “bẫy nuốt mạng” tinh vi của nhóm sát thủ chuyên giết người theo hợp đồng. Đứng đầu là Young Il (Gang Dong-won) cùng các cộng sự bao gồm: cố vấn Jackie (Lee Mi-sook), chuyên gia cải trang (Lee Hyun-woo) và “thực tập” Jum Man (Tang Jun-sang) - thành viên trẻ tuổi nhất đội. Trong một lần đảm nhận nhiệm vụ đầy mạo hiểm là triệt tiêu một chính trị gia cấp cao, Young Il đã phải đối mặt với hàng loạt sự kiện kỳ lạ và đáng ngờ. Khi nhận thấy bản thân chính là mục tiêu tiếp theo của “bẫy nuốt mạng”, Young Il bắt đầu rơi vào tình thế không thể tin tưởng bất kỳ ai. Từ đó, phim mở ra một cuộc loại trừ đẫm máu ly kỳ và hấp dẫn.');
INSERT INTO phim VALUES ('13', 'Những Kẻ Theo Dõi', 'https://files.betacorp.vn/media%2fimages%2f2024%2f05%2f28%2f140624%2Ddraft%2Dke%2Dtheo%2Ddoi%2D151657%2D280524%2D20.jpg', 'Ishana Shyamalan', 'Dakota Fanning, Georgina Campbell, Oliver Finnegan, Olwen Fouere,…', '102 ', 'Tiếng Anh', '16', 'Bộ phim theo chân Mina, một họa sĩ 28 tuổi bị lạc trong khu rừng hoang sơ ở phía tây Ireland. Khi Mina tìm được nơi trú ẩn, cô không hề biết rằng mình đã bị mắc kẹt cùng ba người lạ khác, mà tất cả đều đang bị theo dõi và săn lùng bởi những sinh vật bí ẩn mỗi đêm.');
INSERT INTO phim VALUES ('14', 'Những Mảnh Ghép Cảm Xúc 2', 'https://files.betacorp.vn/media%2fimages%2f2024%2f05%2f28%2f140624%2Ddraft%2Dinside%2Dout%2D2%2D152157%2D280524%2D95.png', 'Kelsey Mann', 'Amy Poehler, Phyllis Smith, Lewis Black', '96 ', 'Tiếng Việt', '1', 'Theo chân Riley, ở tuổi thiếu niên, cô gặp phải những cảm xúc mới.');
INSERT INTO phim VALUES ('15', 'THÁNG TƯ, NGÀY EM ĐẾN', 'https://iguov8nhvyobj.vcdn.cloud/media/catalog/product/cache/1/image/c5f0a1eff4c394a251036189ccddaacd/4/7/470wx700h-april.jpg', 'Tomokazu Yamada', 'Satoh Takeru, Mori Nana, Nagasawa Masami', '108 ', 'Tiếng Nhật', '13', 'Fujishiro Shun (Satoh Takeru) đang chuẩn bị kết hôn. Một ngày tháng Tư, Fujishiro bỗng nhận được lá thư từ Haru (Nana Mori), mối tình 10 năm trước của anh. Cùng lúc đó, vợ sắp cưới Fujishiro là Yayoi (Masami Nagasawa) đột nhiên biến mất. Fujishiro bắt đầu bước vào hành trình tìm kiếm người người vợ chưa cưới với những kỷ niệm lúc cả hai bên nhau, cùng lúc đó hồi ức tình yêu thanh xuân cũng ùa về. Bộ phim mang màu sắc lãng mạn với nhiều cảnh quay trải dài khắp Tokyo, Uyuni (Bolivia), Prague (Cộng hòa Séc), Iceland và các quốc gia khác trên thế giới');
INSERT INTO phim VALUES ('16', 'HÀNH TINH KHỈ: VƯƠNG QUỐC MỚI', 'https://iguov8nhvyobj.vcdn.cloud/media/catalog/product/cache/1/image/c5f0a1eff4c394a251036189ccddaacd/f/z/fzone_007c_g_vie-vn_4x5_.jpg', 'Wes Ball', 'Owen Teague, Freya Allan, Kevin Durand, Peter Macon, and William H. Macy', '144 ', 'Tiếng Anh', '13', 'Đạo diễn Wes Ball mang một hơi thở mới đến loạt phim điện ảnh danh tiếng này. Lấy bối cảnh nhiều đời sau sự ra đi của Vua Khỉ Caesar, hành tinh này là nơi loài khỉ thống trị, còn loài người dần lui về trong bóng tối. Khi một thủ lĩnh khỉ có tên Proximus Caesar xây dựng đế chế của mình, chú khỉ trẻ tuổi Noa bắt đầu một hành trình gian khổ, đặt câu hỏi về tất cả những gì anh ta đã biết về quá khứ và đưa ra những lựa chọn định hình lại tương lai cho cả loài khỉ và loài người.');
INSERT INTO phim VALUES ('17', 'NHỮNG NGƯỜI BẠN TƯỞNG TƯỢNG', 'https://iguov8nhvyobj.vcdn.cloud/media/catalog/product/cache/1/image/c5f0a1eff4c394a251036189ccddaacd/i/f/if_movie_poster_700x1000.jpg', 'John Krasinski', 'Ryan Reynolds, Cailey Fleming, John Krasinski', '104 ', 'Tiếng Anh', '1', 'Bộ phim xoay quanh một cô bé bất ngờ phát hiện ra mình có thể nhìn thấy những người bạn tưởng tượng của mọi người. Và cuộc hành trình bắt đầu khi cô bé sử dụng siêu năng lực của mình để giúp đỡ những người bạn tưởng tượng này tránh khỏi việc bị bỏ rơi và lãng quên bằng cách tìm kiếm, kết nối chúng với những đứa trẻ.');
INSERT INTO phim VALUES ('18', 'Haikyu!!: Trận Chiến Bãi Phế Liệu', 'https://iguov8nhvyobj.vcdn.cloud/media/catalog/product/cache/1/image/c5f0a1eff4c394a251036189ccddaacd/g/l/glx_hqm_kv_social.jpg', 'Susumu Mitsunaka', 'Soon', '85 ', 'Tiếng Nhật', '1', 'Một trong những series manga và anime thể thao về bóng chuyền nổi tiếng nhất mọi thời đại. Cuộc đối đầu bóng chuyền giữa hai đối thủ đầy "duyên nợ" Cao trung Karasuno và THPT Nekoma hứa hẹn sẽ vô cùng kịch tính và không kém phần thú vị. Bạn sẽ theo team Quạ hay team Mèo?');
INSERT INTO phim VALUES ('19', 'VÂY HÃM: KẺ TRỪNG PHẠT', 'https://iguov8nhvyobj.vcdn.cloud/media/catalog/product/cache/1/image/c5f0a1eff4c394a251036189ccddaacd/4/0/406x600-roundup_1.jpg', 'Heo Myeong Haeng', 'Ma Dong-seok, Kim Mu-yeol, Lee Joo-bin', '109 ', 'Tiếng Hàn', '18', 'Siêu cớm Ma Seok-do tái xuất để đối đầu với những tội phạm tinh vi trong giới công nghệ. Nắm đấm trứ danh liệu có phát huy được sức mạnh trước liên minh tội phạm của thiên tài công nghệ và ông trùm nhà cái lớn nhất châu Á?');

CREATE TABLE `productmovie`.`dangphim` (
  `theloai` VARCHAR(10) NOT NULL,
  `tentheloai` TEXT NULL,
  `theloaiid` INT NOT NULL,
  PRIMARY KEY (`theloaiid`));

INSERT INTO dangphim VALUES ('P', 'Mọi độ tuổi', '1');
INSERT INTO dangphim VALUES ('T13', '13 tuổi trở lên', '13');
INSERT INTO dangphim VALUES ('T16', '16 tuổi trở lên', '16');
INSERT INTO dangphim VALUES ('T18', '18 tuổi trở lên', '18');

CREATE TABLE `productmovie`.`toolbarproduct` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` TEXT NULL,
  `image` TEXT NOT NULL,
  PRIMARY KEY (`id`));
  
INSERT INTO toolbarproduct VALUES ('1', 'Đăng nhập', 'https://banner2.cleanpng.com/20180630/psp/kisspng-computer-icons-login-user-profile-5b383c44697cb0.6228623815304121004321.jpg');
INSERT INTO toolbarproduct VALUES ('2', 'Giá vé', 'https://banner2.cleanpng.com/20180331/aqq/kisspng-ticket-cinema-film-computer-icons-cinema-ticket-5abf09e4e8a9e8.743518201522469348953.jpg');
INSERT INTO toolbarproduct VALUES ('3', 'Mọi lứa tuổi', 'https://www.betacinemas.vn/Assets/Common/icons/films/p.png');
INSERT INTO toolbarproduct VALUES ('4', 'Trên 13 tuổi', 'https://www.betacinemas.vn/Assets/Common/icons/films/c-13.png');
INSERT INTO toolbarproduct VALUES ('5', 'Trên 16 tuổi', 'https://www.betacinemas.vn/Assets/Common/icons/films/c-16.png');
INSERT INTO toolbarproduct VALUES ('6', 'Trên 18 tuổi', 'https://www.betacinemas.vn/Assets/Common/icons/films/c-18.png');

/*
Bảng user
*/
CREATE TABLE `users` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`email` VARCHAR(255) NOT NULL,
	`pass` VARCHAR(100) NOT NULL,
	PRIMARY KEY (`id`),
	UNIQUE INDEX `email` (`email`)
)
ENGINE=InnoDB;


