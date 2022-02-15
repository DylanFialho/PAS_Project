@extends('layouts.app')

@section('content')
@if (Route::has('login'))
@auth
<div class="card-header">{{ __('Criar Jogo') }}</div>
<div class="col-lg-1"></div>
<div class="card-body">
    @if (session('status'))
        <div class="alert alert-success" role="alert">
            {{ session('status') }}
        </div>
    @endif
<form action="{{ route('game.store') }}" method="POST">
        @csrf
        <div class="form-group">
            <label for="txtTitle">Email:</label>
            <input type="text" class="form-control" id="txtEmail" placeholder="Email" name="txtEmail">
        </div>
        <div class="form-group">
            <label for="txtAuthor">Password:</label>
            <input type="text" class="form-control" id="txtPassword" placeholder="Password" name="txtPassword">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
    </form>
</div>

<div class="hidden fixed top-0 right-0 px-6 py-4 sm:block">
        <a href="{{ url('/home') }}" class="text-sm text-gray-700 dark:text-gray-500 underline">Home</a>
    @else
        <a href="{{ route('login') }}" class="text-sm text-gray-700 dark:text-gray-500 underline">Log in</a>

        @if (Route::has('register'))
            <a href="{{ route('register') }}" class="ml-4 text-sm text-gray-700 dark:text-gray-500 underline">Register</a>
        @endif
    @endauth
</div>
    @endif
@endsection