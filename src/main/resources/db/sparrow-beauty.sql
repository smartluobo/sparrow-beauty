ALTER TABLE `sparrow-beauty`.`tb_coupons`
  CHANGE `coupons_poster` `coupons_poster` VARCHAR(128) CHARSET utf8 COLLATE utf8_general_ci NULL   COMMENT '优惠券弹窗海报',
  ADD COLUMN `coupons_list_poster` VARCHAR(128) NULL   COMMENT '优惠券列表页海报' AFTER `use_scope`;
