USE [EventManagement]
GO
SET IDENTITY_INSERT [dbo].[city_size] ON 

GO
INSERT [dbo].[city_size] ([cs_id], [cs_code], [cs_active], [cs_name]) VALUES (1, N'S', 1, N'MALI')
GO
INSERT [dbo].[city_size] ([cs_id], [cs_code], [cs_active], [cs_name]) VALUES (2, N'M', 1, N'SREDNJI')
GO
INSERT [dbo].[city_size] ([cs_id], [cs_code], [cs_active], [cs_name]) VALUES (3, N'L', 1, N'VELIK')
GO
SET IDENTITY_INSERT [dbo].[city_size] OFF
GO
SET IDENTITY_INSERT [dbo].[org_unit_type] ON 

GO
INSERT [dbo].[org_unit_type] ([out_id], [out_code], [out_active], [out_name]) VALUES (1, N'REG', 1, N'REGIJA')
GO
INSERT [dbo].[org_unit_type] ([out_id], [out_code], [out_active], [out_name]) VALUES (2, N'ZUP', 1, N'ŽUPANIJA')
GO
SET IDENTITY_INSERT [dbo].[org_unit_type] OFF
GO
SET IDENTITY_INSERT [dbo].[org_unit] ON 

GO
INSERT [dbo].[org_unit] ([ou_id], [ou_descr], [ou_name], [ou_parent_id], [ou_type_id]) VALUES (8, N'Sjeverozapadna Hrvatska', N'Sjeverozapadna Hrvatska', NULL, 1)
GO
INSERT [dbo].[org_unit] ([ou_id], [ou_descr], [ou_name], [ou_parent_id], [ou_type_id]) VALUES (9, N'Središnja i Istočna Hrvatska', N'Središnja i Istočna Hrvatska', NULL, 1)
GO
INSERT [dbo].[org_unit] ([ou_id], [ou_descr], [ou_name], [ou_parent_id], [ou_type_id]) VALUES (10, N'Jadranska Hrvatska', N'Jadranska Hrvatska', NULL, 1)
GO
INSERT [dbo].[org_unit] ([ou_id], [ou_descr], [ou_name], [ou_parent_id], [ou_type_id]) VALUES (11, N'Grad Zagreb', N'Grad Zagreb', 8, 2)
GO
INSERT [dbo].[org_unit] ([ou_id], [ou_descr], [ou_name], [ou_parent_id], [ou_type_id]) VALUES (12, N'Zagrebačka županija', N'Zagrebačka županija', 8, 2)
GO
INSERT [dbo].[org_unit] ([ou_id], [ou_descr], [ou_name], [ou_parent_id], [ou_type_id]) VALUES (13, N'Krapinsko-zagorska županija', N'Krapinsko-zagorska županija', 8, 2)
GO
INSERT [dbo].[org_unit] ([ou_id], [ou_descr], [ou_name], [ou_parent_id], [ou_type_id]) VALUES (14, N'Varaždinska županija', N'Varaždinska županija', 8, 2)
GO
INSERT [dbo].[org_unit] ([ou_id], [ou_descr], [ou_name], [ou_parent_id], [ou_type_id]) VALUES (15, N'Koprivničko-križevačka županija', N'Koprivničko-križevačka županija', 8, 2)
GO
INSERT [dbo].[org_unit] ([ou_id], [ou_descr], [ou_name], [ou_parent_id], [ou_type_id]) VALUES (16, N'Međimurska županija', N'Međimurska županija', 8, 2)
GO
INSERT [dbo].[org_unit] ([ou_id], [ou_descr], [ou_name], [ou_parent_id], [ou_type_id]) VALUES (17, N'Bjelovarsko-bilogorska županija', N'Bjelovarsko-bilogorska županija', 9, 2)
GO
INSERT [dbo].[org_unit] ([ou_id], [ou_descr], [ou_name], [ou_parent_id], [ou_type_id]) VALUES (18, N'Virovitičko-podravska županija', N'Virovitičko-podravska županija', 9, 2)
GO
INSERT [dbo].[org_unit] ([ou_id], [ou_descr], [ou_name], [ou_parent_id], [ou_type_id]) VALUES (19, N'Požeško-slavonska županija', N'Požeško-slavonska županija', 9, 2)
GO
INSERT [dbo].[org_unit] ([ou_id], [ou_descr], [ou_name], [ou_parent_id], [ou_type_id]) VALUES (20, N'Brodsko-posavska županija', N'Brodsko-posavska županija', 9, 2)
GO
INSERT [dbo].[org_unit] ([ou_id], [ou_descr], [ou_name], [ou_parent_id], [ou_type_id]) VALUES (21, N'Osječko-baranjska županija', N'Osječko-baranjska županija', 9, 2)
GO
INSERT [dbo].[org_unit] ([ou_id], [ou_descr], [ou_name], [ou_parent_id], [ou_type_id]) VALUES (22, N'Vukovarsko-srijemska županija', N'Vukovarsko-srijemska županija', 9, 2)
GO
INSERT [dbo].[org_unit] ([ou_id], [ou_descr], [ou_name], [ou_parent_id], [ou_type_id]) VALUES (23, N'Karlovačka županija', N'Karlovačka županija', 9, 2)
GO
INSERT [dbo].[org_unit] ([ou_id], [ou_descr], [ou_name], [ou_parent_id], [ou_type_id]) VALUES (24, N'Sisačko-moslavačka županija', N'Sisačko-moslavačka županija', 9, 2)
GO
INSERT [dbo].[org_unit] ([ou_id], [ou_descr], [ou_name], [ou_parent_id], [ou_type_id]) VALUES (25, N'Primorsko-goranska županija', N'Primorsko-goranska županija', 10, 2)
GO
INSERT [dbo].[org_unit] ([ou_id], [ou_descr], [ou_name], [ou_parent_id], [ou_type_id]) VALUES (26, N'Ličko-senjska županija', N'Ličko-senjska županija', 10, 2)
GO
INSERT [dbo].[org_unit] ([ou_id], [ou_descr], [ou_name], [ou_parent_id], [ou_type_id]) VALUES (27, N'Zadarska županija', N'Zadarska županija', 10, 2)
GO
INSERT [dbo].[org_unit] ([ou_id], [ou_descr], [ou_name], [ou_parent_id], [ou_type_id]) VALUES (28, N'Šibensko-kninska županija', N'Šibensko-kninska županija', 10, 2)
GO
INSERT [dbo].[org_unit] ([ou_id], [ou_descr], [ou_name], [ou_parent_id], [ou_type_id]) VALUES (29, N'Splitsko-dalmatinska županija', N'Splitsko-dalmatinska županija', 10, 2)
GO
INSERT [dbo].[org_unit] ([ou_id], [ou_descr], [ou_name], [ou_parent_id], [ou_type_id]) VALUES (30, N'Istarska županija', N'Istarska županija', 10, 2)
GO
INSERT [dbo].[org_unit] ([ou_id], [ou_descr], [ou_name], [ou_parent_id], [ou_type_id]) VALUES (31, N'Dubrovačko-neretvanska županija', N'Dubrovačko-neretvanska županija', 10, 2)
GO
SET IDENTITY_INSERT [dbo].[org_unit] OFF
GO
SET IDENTITY_INSERT [dbo].[city] ON 

GO
INSERT [dbo].[city] ([c_id], [c_code], [c_name], [c_size_id], [c_ou_id]) VALUES (1, N'ZAG', N'Zagreb', 3, 11)
GO
INSERT [dbo].[city] ([c_id], [c_code], [c_name], [c_size_id], [c_ou_id]) VALUES (2, N'VGO', N'Velika Gorica', 3, 12)
GO
INSERT [dbo].[city] ([c_id], [c_code], [c_name], [c_size_id], [c_ou_id]) VALUES (3, N'ZAP', N'Zaprešić', 2, 12)
GO
INSERT [dbo].[city] ([c_id], [c_code], [c_name], [c_size_id], [c_ou_id]) VALUES (4, N'IVG', N'Ivanić Grad', 1, 12)
GO
INSERT [dbo].[city] ([c_id], [c_code], [c_name], [c_size_id], [c_ou_id]) VALUES (5, N'DJS', N'Donja Stubica', 3, 13)
GO
INSERT [dbo].[city] ([c_id], [c_code], [c_name], [c_size_id], [c_ou_id]) VALUES (6, N'ORO', N'Oroslavlje', 2, 13)
GO
INSERT [dbo].[city] ([c_id], [c_code], [c_name], [c_size_id], [c_ou_id]) VALUES (7, N'HRA', N'Hrašćina', 1, 13)
GO
INSERT [dbo].[city] ([c_id], [c_code], [c_name], [c_size_id], [c_ou_id]) VALUES (8, N'VZD', N'Varaždin', 3, 14)
GO
INSERT [dbo].[city] ([c_id], [c_code], [c_name], [c_size_id], [c_ou_id]) VALUES (9, N'IVN', N'Ivanec', 2, 14)
GO
INSERT [dbo].[city] ([c_id], [c_code], [c_name], [c_size_id], [c_ou_id]) VALUES (10, N'MBU', N'Mali Bukovec', 1, 14)
GO
INSERT [dbo].[city] ([c_id], [c_code], [c_name], [c_size_id], [c_ou_id]) VALUES (11, N'KZC', N'Križevci', 3, 15)
GO
INSERT [dbo].[city] ([c_id], [c_code], [c_name], [c_size_id], [c_ou_id]) VALUES (12, N'SIZ', N'Sveti Ivan Žabno', 2, 15)
GO
INSERT [dbo].[city] ([c_id], [c_code], [c_name], [c_size_id], [c_ou_id]) VALUES (13, N'MOL', N'Molve', 1, 15)
GO
INSERT [dbo].[city] ([c_id], [c_code], [c_name], [c_size_id], [c_ou_id]) VALUES (14, N'CKC', N'Čakovec', 3, 16)
GO
INSERT [dbo].[city] ([c_id], [c_code], [c_name], [c_size_id], [c_ou_id]) VALUES (15, N'KTB', N'Kotoriba', 2, 16)
GO
INSERT [dbo].[city] ([c_id], [c_code], [c_name], [c_size_id], [c_ou_id]) VALUES (16, N'MSU', N'Mala Subotica', 1, 16)
GO
INSERT [dbo].[city] ([c_id], [c_code], [c_name], [c_size_id], [c_ou_id]) VALUES (17, N'BJE', N'Bjelovar', 3, 17)
GO
INSERT [dbo].[city] ([c_id], [c_code], [c_name], [c_size_id], [c_ou_id]) VALUES (18, N'DAR', N'Daruvar', 2, 17)
GO
INSERT [dbo].[city] ([c_id], [c_code], [c_name], [c_size_id], [c_ou_id]) VALUES (19, N'GPO', N'Grubišno Polje', 1, 17)
GO
INSERT [dbo].[city] ([c_id], [c_code], [c_name], [c_size_id], [c_ou_id]) VALUES (20, N'VRV', N'Virovitica', 3, 18)
GO
INSERT [dbo].[city] ([c_id], [c_code], [c_name], [c_size_id], [c_ou_id]) VALUES (21, N'SLA', N'Slatina', 2, 18)
GO
INSERT [dbo].[city] ([c_id], [c_code], [c_name], [c_size_id], [c_ou_id]) VALUES (22, N'ORH', N'Orahovica', 1, 18)
GO
INSERT [dbo].[city] ([c_id], [c_code], [c_name], [c_size_id], [c_ou_id]) VALUES (23, N'PZG', N'Požega', 3, 19)
GO
INSERT [dbo].[city] ([c_id], [c_code], [c_name], [c_size_id], [c_ou_id]) VALUES (24, N'LPK', N'Lipik', 2, 19)
GO
INSERT [dbo].[city] ([c_id], [c_code], [c_name], [c_size_id], [c_ou_id]) VALUES (25, N'PLT', N'Pleternica', 1, 19)
GO
INSERT [dbo].[city] ([c_id], [c_code], [c_name], [c_size_id], [c_ou_id]) VALUES (26, N'SBR', N'Slavonski Brod', 3, 20)
GO
INSERT [dbo].[city] ([c_id], [c_code], [c_name], [c_size_id], [c_ou_id]) VALUES (27, N'NGR', N'Nova Gradiška', 2, 20)
GO
INSERT [dbo].[city] ([c_id], [c_code], [c_name], [c_size_id], [c_ou_id]) VALUES (28, N'GVB', N'Gornja Vrba', 1, 20)
GO
INSERT [dbo].[city] ([c_id], [c_code], [c_name], [c_size_id], [c_ou_id]) VALUES (29, N'OSK', N'Osijek', 3, 21)
GO
INSERT [dbo].[city] ([c_id], [c_code], [c_name], [c_size_id], [c_ou_id]) VALUES (30, N'NSC', N'Našice', 2, 21)
GO
INSERT [dbo].[city] ([c_id], [c_code], [c_name], [c_size_id], [c_ou_id]) VALUES (31, N'BMA', N'Beli Manastir', 1, 21)
GO
INSERT [dbo].[city] ([c_id], [c_code], [c_name], [c_size_id], [c_ou_id]) VALUES (32, N'VKV', N'Vukovar', 3, 22)
GO
INSERT [dbo].[city] ([c_id], [c_code], [c_name], [c_size_id], [c_ou_id]) VALUES (33, N'ZPN', N'Županja', 2, 22)
GO
INSERT [dbo].[city] ([c_id], [c_code], [c_name], [c_size_id], [c_ou_id]) VALUES (34, N'ILK', N'Ilok', 1, 22)
GO
INSERT [dbo].[city] ([c_id], [c_code], [c_name], [c_size_id], [c_ou_id]) VALUES (35, N'KAR', N'Karlovac', 3, 23)
GO
INSERT [dbo].[city] ([c_id], [c_code], [c_name], [c_size_id], [c_ou_id]) VALUES (36, N'OGL', N'Ogulin', 2, 23)
GO
INSERT [dbo].[city] ([c_id], [c_code], [c_name], [c_size_id], [c_ou_id]) VALUES (37, N'DRE', N'Duga Resa', 1, 23)
GO
INSERT [dbo].[city] ([c_id], [c_code], [c_name], [c_size_id], [c_ou_id]) VALUES (38, N'SSK', N'Sisak', 3, 24)
GO
INSERT [dbo].[city] ([c_id], [c_code], [c_name], [c_size_id], [c_ou_id]) VALUES (39, N'PTR', N'Petrinja', 2, 24)
GO
INSERT [dbo].[city] ([c_id], [c_code], [c_name], [c_size_id], [c_ou_id]) VALUES (40, N'NOV', N'Novska', 1, 24)
GO
INSERT [dbo].[city] ([c_id], [c_code], [c_name], [c_size_id], [c_ou_id]) VALUES (41, N'RIJ', N'Rijeka', 3, 25)
GO
INSERT [dbo].[city] ([c_id], [c_code], [c_name], [c_size_id], [c_ou_id]) VALUES (42, N'CRI', N'Crikvenica', 2, 25)
GO
INSERT [dbo].[city] ([c_id], [c_code], [c_name], [c_size_id], [c_ou_id]) VALUES (43, N'CBR', N'Čabar', 1, 25)
GO
INSERT [dbo].[city] ([c_id], [c_code], [c_name], [c_size_id], [c_ou_id]) VALUES (44, N'GOS', N'Gospić', 3, 26)
GO
INSERT [dbo].[city] ([c_id], [c_code], [c_name], [c_size_id], [c_ou_id]) VALUES (45, N'OTC', N'Otočac', 2, 26)
GO
INSERT [dbo].[city] ([c_id], [c_code], [c_name], [c_size_id], [c_ou_id]) VALUES (46, N'DLP', N'Donji Lapac', 1, 26)
GO
INSERT [dbo].[city] ([c_id], [c_code], [c_name], [c_size_id], [c_ou_id]) VALUES (47, N'ZDR', N'Zadar', 3, 27)
GO
INSERT [dbo].[city] ([c_id], [c_code], [c_name], [c_size_id], [c_ou_id]) VALUES (48, N'PAG', N'Pag', 2, 27)
GO
INSERT [dbo].[city] ([c_id], [c_code], [c_name], [c_size_id], [c_ou_id]) VALUES (49, N'OBR', N'Obrovac', 1, 27)
GO
INSERT [dbo].[city] ([c_id], [c_code], [c_name], [c_size_id], [c_ou_id]) VALUES (50, N'SBN', N'Šibenik', 3, 28)
GO
INSERT [dbo].[city] ([c_id], [c_code], [c_name], [c_size_id], [c_ou_id]) VALUES (51, N'KNI', N'Knin', 2, 28)
GO
INSERT [dbo].[city] ([c_id], [c_code], [c_name], [c_size_id], [c_ou_id]) VALUES (52, N'VDC', N'Vodice', 1, 28)
GO
INSERT [dbo].[city] ([c_id], [c_code], [c_name], [c_size_id], [c_ou_id]) VALUES (53, N'SPL', N'Split', 3, 29)
GO
INSERT [dbo].[city] ([c_id], [c_code], [c_name], [c_size_id], [c_ou_id]) VALUES (54, N'SNJ', N'Sinj', 2, 29)
GO
INSERT [dbo].[city] ([c_id], [c_code], [c_name], [c_size_id], [c_ou_id]) VALUES (55, N'TRL', N'Trilj', 1, 29)
GO
INSERT [dbo].[city] ([c_id], [c_code], [c_name], [c_size_id], [c_ou_id]) VALUES (56, N'PLA', N'Pula', 3, 30)
GO
INSERT [dbo].[city] ([c_id], [c_code], [c_name], [c_size_id], [c_ou_id]) VALUES (57, N'PRC', N'Poreč', 2, 30)
GO
INSERT [dbo].[city] ([c_id], [c_code], [c_name], [c_size_id], [c_ou_id]) VALUES (58, N'BUJ', N'Buje', 1, 30)
GO
INSERT [dbo].[city] ([c_id], [c_code], [c_name], [c_size_id], [c_ou_id]) VALUES (59, N'DUB', N'Dubrovnik', 3, 31)
GO
INSERT [dbo].[city] ([c_id], [c_code], [c_name], [c_size_id], [c_ou_id]) VALUES (60, N'KOR', N'Korčula', 2, 31)
GO
INSERT [dbo].[city] ([c_id], [c_code], [c_name], [c_size_id], [c_ou_id]) VALUES (61, N'OPU', N'Opuzen', 1, 31)
GO
SET IDENTITY_INSERT [dbo].[city] OFF
GO
SET IDENTITY_INSERT [dbo].[event] ON 

GO
INSERT [dbo].[event] ([ev_id], [ev_name], [ev_city_id], [ev_start], [ev_end], [ev_free_entry]) VALUES (1, N'Trka45', 1, CAST(N'2019-04-08T00:00:00.0000000' AS DateTime2), CAST(N'2019-04-11T00:00:00.0000000' AS DateTime2), 1)
GO
INSERT [dbo].[event] ([ev_id], [ev_name], [ev_city_id], [ev_start], [ev_end], [ev_free_entry]) VALUES (37, N'Novi događaj', 3, CAST(N'2019-04-19T00:00:00.0000000' AS DateTime2), CAST(N'2019-04-20T00:00:00.0000000' AS DateTime2), 1)
GO
INSERT [dbo].[event] ([ev_id], [ev_name], [ev_city_id], [ev_start], [ev_end], [ev_free_entry]) VALUES (38, N'Humanitarna utrka', 18, CAST(N'2019-04-07T00:00:00.0000000' AS DateTime2), CAST(N'2019-04-08T00:00:00.0000000' AS DateTime2), 1)
GO
INSERT [dbo].[event] ([ev_id], [ev_name], [ev_city_id], [ev_start], [ev_end], [ev_free_entry]) VALUES (39, N'Božićni koncert', 42, CAST(N'2019-04-07T00:00:00.0000000' AS DateTime2), CAST(N'2019-04-09T00:00:00.0000000' AS DateTime2), 0)
GO
INSERT [dbo].[event] ([ev_id], [ev_name], [ev_city_id], [ev_start], [ev_end], [ev_free_entry]) VALUES (40, N'Skupljanje donacija', 31, CAST(N'2019-04-01T00:00:00.0000000' AS DateTime2), CAST(N'2019-05-31T00:00:00.0000000' AS DateTime2), 1)
GO
SET IDENTITY_INSERT [dbo].[event] OFF
GO
