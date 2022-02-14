<?php

namespace App\Http\Controllers;
use App\Models\UserApp;

use Illuminate\Http\Request;

class UserApiController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        //
        $user = UserApp::all();
        return view('user.list', compact('user','user'));
    }
 
    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        //
        return view('user.create');
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
        $request->validate([
            'email'=>'required',
            'password'=> 'required'
        ]);
 
        $student = new Student([
            'email' => $request->get('email'),
            'password'=> $request->get('password')
        ]);
 
        $student->save();
        return redirect('/user_apps')->with('success', 'Student has been added');
    }
 
    /**
     * Display the specified resource.
     *
     * @param  \App\Student  $student
     * @return \Illuminate\Http\Response
     */
    public function show(Student $student)
    {
        //
        return view('user.view',compact('user'));
    }
 
    /**
     * Show the form for editing the specified resource.
     *
     * @param  \App\User  $user
     * @return \Illuminate\Http\Response
     */
    public function edit(UserApp $user)
    {
        //
        return view('user.edit',compact('user'));
    }
 
    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \App\UserApp  $user
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request,$id)
    {
        //
 
        $request->validate([
            'email'=>'required',
            'password'=> 'required'
        ]);
 
 
        $user = UserApp::find($id);
        $user->email = $request->get('email');
        $user->password = $request->get('password');
 
        $user->update();
 
        return redirect('/user_apps')->with('success', 'User updated successfully');
    }
 
    /**
     * Remove the specified resource from storage.
     *
     * @param  \App\UserApp  $user
     * @return \Illuminate\Http\Response
     */
    public function destroy(UserApp $user)
    {
        //
        $student->delete();
        return redirect('/user')->with('success', 'User deleted successfully');
    }
}
?>