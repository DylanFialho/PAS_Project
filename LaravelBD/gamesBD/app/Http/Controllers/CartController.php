<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

use App\Models\Cart;

class CartController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        //
        $cart = Cart::get()->toJson(JSON_PRETTY_PRINT);
        return response($cart, 200);
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create(Request $request)
    {
        $cart = new Cart;
        $cart->id_game = $request->id_game;
        $cart->id_user = $request->id_user;
        $cart->save();

        return response()->json([
            "message" => "user record created"
        ], 201);
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
        //
    }

    /**
     * Display the specified resource.
     *
     * @param  \App\Models\Cart  $cart
     * @return \Illuminate\Http\Response
     */
    public function show($id)
    {
        //
        if (Cart::where('id', $id)->exists()) {
            $cart = Cart::where('id', $id)->get()->toJson(JSON_PRETTY_PRINT);
            return response($cart, 200);
          } else {
            return response()->json([
              "message" => "User not found"
            ], 404);
          }    
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  \App\Models\Cart  $cart
     * @return \Illuminate\Http\Response
     */
    public function edit(Cart $cart)
    {
        //
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \App\Models\Cart  $cart
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, $id)
    {
        //
        if (Cart::where('id', $id)->exists()) {
            $cart = Cart::find($id);
    
            $cart->id_game = is_null($request->id_game) ? $cart->id_game : $request->id_game;
            $cart->id_user = is_null($request->id_user) ? $cart->id_user : $request->id_user;
            $cart->save();
    
            return response()->json([
              "message" => "records updated successfully"
            ], 200);
          } else {
            return response()->json([
              "message" => "User not found"
            ], 404);
          }
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  \App\Models\Cart  $cart
     * @return \Illuminate\Http\Response
     */
    public function destroy($id)
    {
        //
        if(Cart::where('id', $id)->exists()) {
            $cart = Cart::find($id);
            $cart->delete();
    
            return response()->json([
              "message" => "records deleted"
            ], 202);
          } else {
            return response()->json([
              "message" => "Cart not found"
            ], 404);
          }
    }
}