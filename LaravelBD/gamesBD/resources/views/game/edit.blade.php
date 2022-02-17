@extends('layouts.app')

@section('content')
@if (Route::has('login'))
@auth
<div class="card-header">{{ __('Editar Jogo') }}</div>
<div class="col-lg-1"></div>
<div class="card-body">
<div class="col-lg-1">
</div>
    @if (session('status'))
        <div class="alert alert-success" role="alert">
            {{ session('status') }}
        </div>
    @endif

<form method="post" action="{{ route('game.update',$game->id) }}" >
        @method('PATCH')
        @csrf
        <div class="form-group">
            <label for="txtTitle">Titulo:</label>
            <input type="text" class="form-control" id="txtTitle" placeholder="Titulo" name="txtTitle"  value="{{ $game->name }}">
        </div>
        <div class="form-group">
            <label for="txtPublisher">Descrição:</label>
            <input type="text" class="form-control" id="txtDescription" placeholder="Descrição" name="txtDescription" value="{{ $game->description }}">
        </div>
        <div class="form-group">
            <label for="txtEdition">Categoria:</label>
            <input type="text" class="form-control" id="txtCategory" placeholder="Categoria" name="txtCategory"  value="{{ $game->category }}">
        </div>
        <div class="form-group">
            <label for="txtAuthor">Consolas:</label>
            <input type="text" class="form-control" id="txtConsole" placeholder="Autor" name="txtConsole"  value="{{ $game->console }}">
        </div>
        <div class="form-group">
            <label for="txtPublisher">Preço:</label>
            <input type="text" class="form-control" id="txtPrice" placeholder="Preço" name="txtPrice" value="{{ $game->price }}">
        </div>
        <div class="form-group">
            <label for="txtImage">Imagem:</label>
            <input type="text" class="form-control" id="txtImage" placeholder="Image" name="txtImage" value="{{ $game->url }}">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
    </form>
</div>

<a class="btn btn-primary" href="{{ url('game') }}"> Back</a>

<div class="hidden fixed top-0 right-0 px-6 py-4 sm:block">
        <a href="{{ url('/home') }}" class="text-sm text-gray-700 dark:text-gray-500 underline">Home</a>
    @else
        <a href="{{ route('login') }}" class="text-sm text-gray-700 dark:text-gray-500 underline">Log in</a>
    @endauth
</div>
    @endif
@endsection