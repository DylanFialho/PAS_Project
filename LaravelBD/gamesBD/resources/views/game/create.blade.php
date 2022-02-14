@extends('book.layouts.app')

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
<form action="{{ route('book.store') }}" method="POST">
        @csrf
        <div class="form-group">
            <label for="txtTitle">Titulo:</label>
            <input type="text" class="form-control" id="txtTitle" placeholder="Titulo" name="txtTitle">
        </div>
        <div class="form-group">
            <label for="txtAuthor">Descrição:</label>
            <input type="text" class="form-control" id="txtDescription" placeholder="Descrição" name="txtDescription">
        </div>
        <div class="form-group">
            <label for="txtEdition">Categoria:</label>
            <input type="text" class="form-control" id="txtCategory" placeholder="Categoria" name="txtCategory">
        </div>
        <div class="form-group">
            <label for="txtAuthor">Consolas:</label>
            <input type="text" class="form-control" id="txtConsole" placeholder="Consola" name="txtConsole">
        </div>
        <div class="form-group">
            <label for="txtPublisher">Preço:</label>
            <input type="text" class="form-control" id="txtPrice" placeholder="Preco" name="txtPrice" >
        </div>
        <div class="form-group">
            <label for="txtImage">Imagem:</label>
            <input type="text" class="form-control" id="txtImage" placeholder="Image" name="txtImage" value="{{ $game->url }}">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
    </form>
    {{ __('You are logged in!') }}
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