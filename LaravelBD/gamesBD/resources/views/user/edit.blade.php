@extends('layouts.app')

@section('content')
@if (Route::has('login'))
@auth
<div class="card-header">{{ __('Editar Utilizador') }}</div>
<div class="col-lg-1"></div>
<div class="card-body">
<div class="col-lg-1">
</div>
    @if (session('status'))
        <div class="alert alert-success" role="alert">
            {{ session('status') }}
        </div>
    @endif

<form method="post" action="{{ route('user.update',$user->id) }}" >
        @method('PATCH')
        @csrf
        <div class="form-group">
            <label for="txtEmail">Email:</label>
            <input type="text" class="form-control" id="txtEmail" placeholder="Email" name="txtEmail"  value="{{ $user->email }}">
        </div>
        <div class="form-group">
            <label for="txtPassword">Password:</label>
            <input type="text" class="form-control" id="txtPassword" placeholder="Password" name="txtPassword" value="{{ $user->password }}">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
    </form>
</div>

<a class="btn btn-primary" href="{{ url('user') }}"> Back</a>

<div class="hidden fixed top-0 right-0 px-6 py-4 sm:block">
        <a href="{{ url('/home') }}" class="text-sm text-gray-700 dark:text-gray-500 underline">Home</a>
    @else
        <a href="{{ route('login') }}" class="text-sm text-gray-700 dark:text-gray-500 underline">Log in</a>

    @endauth
</div>
    @endif
@endsection