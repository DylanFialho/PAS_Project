<?php

namespace App\Http\Controllers;
use App\Models\UserApp;

use Illuminate\Http\Request;

class UserApiController extends Controller
{
  public function index()
    {
        //
        $user = UserApp::all();
        return view('user.list', compact('user', 'user'));
    }

    public function create()
    {
        //
        return view('user.create');
    }

    public function store(Request $request)
    {
        //
        $request->validate([
            'txtEmail' => 'required',
            'txtPassword'=>'required'
        ]);

        $user = new UserApp([
            'email'=> $request->get('txtEmail'),
            'password' => $request->get('txtPassword')
        ]);

        $user->save();
        return redirect('/user')->with('success', 'User has been added');
    }

    public function show(UserApp $user)
    {
        return view('user.view',compact('user'));
    }

    public function edit(UserApp $user)
    {
        return view('user.edit',compact('user'));
    }

    public function update(Request $request,$id)
    {
        $request->validate([
          
            'txtEmail' => 'required',
            'txtPassword'=>'required'
        ]);


        $user = UserApp::find($id);
        $user->email = $request->get('txtEmail');
        $user->password = $request->get('txtPassword');
        $user->update();

        return redirect('/user')->with('success', 'User updated successfully');
    }

    public function destroy(UserApp $user)
    {
        //
        $user->delete();
        return redirect('/user')->with('success', 'User deleted successfully');
    }

    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function indexApi()
    {
        //
        $user = UserApp::get()->toJson(JSON_PRETTY_PRINT);
        return response($user, 200);
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function createApi(Request $request)
    {
        $user = new UserApp;
        $user->email = $request->email;
        $user->password = $request->password;

        if(UserApp::where('email', $user->email)->exists()){
          return response()->json([
            "message" => "User ja existe"
            ], 409);
        }else{
            $user->save();
            return response()->json([
            "message" => "user record created"
            ], 201);
        }
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function storeApi(Request $request)
    {
        //
    }

    /**
     * Display the specified resource.
     *
     * @param  \App\Models\UserApp  $user
     * @return \Illuminate\Http\Response
     */
    public function showApi($id)
    {
        //
        if (UserApp::where('id', $id)->exists()) {
            $user = UserApp::where('id', $id)->get()->toJson(JSON_PRETTY_PRINT);
            return response($user, 200);
          } else {
            return response()->json([
              "message" => "User not found"
            ], 404);
          }    
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  \App\Models\UserApp  $user
     * @return \Illuminate\Http\Response
     */
    public function editApi(UserApp $user)
    {
        //
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \App\Models\UserApp  $user
     * @return \Illuminate\Http\Response
     */
    public function updateApi(Request $request, $id)
    {
        //
        if (UserApp::where('id', $id)->exists()) {
            $user = UserApp::find($id);
    
            $user->email = is_null($request->email) ? $user->email : $request->email;
            $user->password = is_null($request->password) ? $user->password : $request->password;
            $user->save();
    
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
     * @param  \App\Models\UserApp  $user
     * @return \Illuminate\Http\Response
     */
    public function destroyApi($id)
    {
        //
        if(UserApp::where('id', $id)->exists()) {
            $user = UserApp::find($id);
            $user->delete();
    
            return response()->json([
              "message" => "records deleted"
            ], 202);
          } else {
            return response()->json([
              "message" => "User not found"
            ], 404);
          }
    }

    public function getUserByEmailApi($email){
      if (UserApp::where('email', $email)->exists()) {
          $user = UserApp::where('email', $email)->get()->toJson(JSON_PRETTY_PRINT);
          return response($user, 200);
        } else {
          return response()->json(["message" => "Utilizador nao existe"]
          , 404);
        }
  }

  public function getUserByPasswordAndEmail(Request $request, $email, $password){
    if (UserApp::where('email', $email)->where('password', $password)->exists()) {
      $login = UserApp::where('email', $email)->where('password', $password)->get()->toJson(JSON_PRETTY_PRINT);
      return response($login, 200);
    } else {
      return response()->json(["message" => "Utilizador nao encontrado por email e pass"], 404);
    }
  }
}