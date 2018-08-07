package com.onegroup.controller;

import com.onegroup.controller.auctionaction.AuctionBuyAction;
import com.onegroup.controller.auctionaction.AuctionBuyFormAction;
import com.onegroup.controller.auctionaction.AuctionDeleteAction;
import com.onegroup.controller.auctionaction.AuctionInsertAction;
import com.onegroup.controller.auctionaction.AuctionInsertFormAction;
import com.onegroup.controller.auctionaction.AuctionListAction;
import com.onegroup.controller.auctionaction.AuctionViewAction;
import com.onegroup.controller.buysaleaction.BuyCancelAction;
import com.onegroup.controller.buysaleaction.BuyCompleteAction;
import com.onegroup.controller.buysaleaction.BuyListAction;
import com.onegroup.controller.buysaleaction.BuyListDeleteAction;
import com.onegroup.controller.buysaleaction.SaleListAction;
import com.onegroup.controller.buysaleaction.SaleListDeleteAction;
import com.onegroup.controller.cashaction.CashChargeAction;
import com.onegroup.controller.cashaction.CashChargeFormAction;
import com.onegroup.controller.freeboardaction.FreeBoardDeleteAction;
import com.onegroup.controller.freeboardaction.FreeBoardListAction;
import com.onegroup.controller.freeboardaction.FreeBoardMyViewAction;
import com.onegroup.controller.freeboardaction.FreeBoardUpadateAction;
import com.onegroup.controller.freeboardaction.FreeBoardUpdateFormAction;
import com.onegroup.controller.freeboardaction.FreeBoardViewAction;
import com.onegroup.controller.freeboardaction.FreeBoardWriteAction;
import com.onegroup.controller.freeboardaction.FreeBoardWriteFormAction;
import com.onegroup.controller.loginaction.Action;
import com.onegroup.controller.loginaction.DropUserAction;
import com.onegroup.controller.loginaction.IdCheckAction;
import com.onegroup.controller.loginaction.InfoUpdateAction;
import com.onegroup.controller.loginaction.InfoUpdateFormAction;
import com.onegroup.controller.loginaction.JoinAction;
import com.onegroup.controller.loginaction.JoinFormAction;
import com.onegroup.controller.loginaction.LoginAction;
import com.onegroup.controller.loginaction.LoginFormAction;
import com.onegroup.controller.loginaction.LogoutAction;
import com.onegroup.controller.loginaction.MyinfoAction;
import com.onegroup.controller.loginaction.SearchIdAction;
import com.onegroup.controller.loginaction.SearchIdFormAction;
import com.onegroup.controller.loginaction.SearchPwAction;
import com.onegroup.controller.loginaction.SearchPwFormAction;
import com.onegroup.controller.marketboardaction.MarketBoardBuyAction;
import com.onegroup.controller.marketboardaction.MarketBoardBuyFormAction;
import com.onegroup.controller.marketboardaction.MarketBoardDeleteAction;
import com.onegroup.controller.marketboardaction.MarketBoardListAction;
import com.onegroup.controller.marketboardaction.MarketBoardUpdateAction;
import com.onegroup.controller.marketboardaction.MarketBoardUpdateFormAction;
import com.onegroup.controller.marketboardaction.MarketBoardViewAction;
import com.onegroup.controller.marketboardaction.MarketBoardWriteAction;
import com.onegroup.controller.marketboardaction.MarketBoardWriteFormAction;
import com.onegroup.controller.noteaction.DeleteNoteAction;
import com.onegroup.controller.noteaction.NoteMainAction;
import com.onegroup.controller.noteaction.NoteViewAction;
import com.onegroup.controller.noteaction.NoteWriteAction;
import com.onegroup.controller.searchformaction.SearchFormAction;

public class ActionFactory {
	private ActionFactory() {
	}

	private static ActionFactory factory = new ActionFactory();

	public static ActionFactory getInstance() {
		return factory;
	}

	public Action getAction(String command) {

		System.out.println("ActionFactory : " + command);

		Action action = null;

		if (command.equals("login")) {
			action = new LoginAction();
		} else if (command.equals("login_form")) {
			action = new LoginFormAction();
		} else if (command.equals("join_form")) {
			action = new JoinFormAction();
		} else if (command.equals("idCheck")) {
			action = new IdCheckAction();
		} else if (command.equals("join")) {
			action = new JoinAction();
		} else if (command.equals("logout")) {
			action = new LogoutAction();
		} else if (command.equals("search_id_form")) {
			action = new SearchIdFormAction();
		} else if (command.equals("search_pw_form")) {
			action = new SearchPwFormAction();
		} else if (command.equals("search_id")) {
			action = new SearchIdAction();
		} else if (command.equals("search_pw")) {
			action = new SearchPwAction();
		} else if (command.equals("note_main")) {
			action = new NoteMainAction();
		} else if (command.equals("note_view")) {
			action = new NoteViewAction();
		} else if (command.equals("note_write")) {
			action = new NoteWriteAction();
		} else if (command.equals("info_update")) {
			action = new InfoUpdateAction();
		} else if (command.equals("info_update_form")) {
			action = new InfoUpdateFormAction();
		} else if (command.equals("my_info")) {
			action = new MyinfoAction();
		} else if (command.equals("free_board_list")) {
			action = new FreeBoardListAction();
		} else if (command.equals("free_board_write_form")) {
			action = new FreeBoardWriteFormAction();
		} else if (command.equals("free_board_write")) {
			action = new FreeBoardWriteAction();
		} else if (command.equals("free_board_view")) {
			action = new FreeBoardViewAction();
		} else if (command.equals("free_board_update_form")) {
			action = new FreeBoardUpdateFormAction();
		} else if (command.equals("free_board_delete")) {
			action = new FreeBoardDeleteAction();
		} else if (command.equals("free_board_update")) {
			action = new FreeBoardUpadateAction();
		} else if (command.equals("free_board_myview")) {
			action = new FreeBoardMyViewAction();
		} else if (command.equals("market_board_list")) {
			action = new MarketBoardListAction();
		} else if (command.equals("market_board_write_form")) {
			action = new MarketBoardWriteFormAction();
		} else if (command.equals("market_board_write")) {
			action = new MarketBoardWriteAction();
		} else if (command.equals("market_board_view")) {
			action = new MarketBoardViewAction();
		} else if (command.equals("market_board_update_form")) {
			action = new MarketBoardUpdateFormAction();
		} else if (command.equals("market_board_update")) {
			action = new MarketBoardUpdateAction();
		} else if (command.equals("market_board_delete")) {
			action = new MarketBoardDeleteAction();
		} else if (command.equals("market_board_buy_form")) {
			action = new MarketBoardBuyFormAction();
		} else if (command.equals("market_board_buy")) {
			action = new MarketBoardBuyAction();
		} else if (command.equals("search_form")) {
			action = new SearchFormAction();
		} else if (command.equals("drop_user")) {
			action = new DropUserAction();
		} else if (command.equals("buy_list")) {
			action = new BuyListAction();
		} else if (command.equals("sale_list")) {
			action = new SaleListAction();
		} else if (command.equals("buy_complete")) {
			action = new BuyCompleteAction();
		} else if (command.equals("buy_cancel")) {
			action = new BuyCancelAction();
		} else if (command.equals("delete_note")) {
			action = new DeleteNoteAction();
		} else if (command.equals("buy_list_delete")) {
			action = new BuyListDeleteAction();
		} else if (command.equals("sale_list_delete")) {
			action = new SaleListDeleteAction();
		} else if (command.equals("auction_buy")) {
			action = new AuctionBuyAction();
		} else if (command.equals("auction_buy_form")) {
			action = new AuctionBuyFormAction();
		} else if (command.equals("auction_view")) {
			action = new AuctionViewAction();
		} else if (command.equals("auction_insert_form")) {
			action = new AuctionInsertFormAction();
		} else if (command.equals("auction_insert")) {
			action = new AuctionInsertAction();
		} else if (command.equals("auction_list")) {
			action = new AuctionListAction();
		} else if (command.equals("auction_delete")) {
			action = new AuctionDeleteAction();
		} else if (command.equals("cash_charge")) {
			action = new CashChargeAction();
		} else if (command.equals("cash_charge_form")) {
			action = new CashChargeFormAction();
		}

		return action;
	}

}
