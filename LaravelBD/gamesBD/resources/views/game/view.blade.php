@extends('layouts.app')

@section('content')
@if (Route::has('login'))
@auth
<div class="card-header">{{ __('Ver Jogo') }}</div>
<div class="col-lg-1"></div>
<div class="card-body">
    @if (session('status'))
        <div class="alert alert-success" role="alert">
            {{ session('status') }}
        </div>
    @endif
    <table class="table table-bordered">
        <tr>
            <th>Titulo:</th>
            <td>{{ $game->name }}</td>
        </tr>
        <tr>
            <th>Descrição:</th>
            <td>{{ $game->description }}</td>
        </tr>
        <tr>
            <th>Categoria:</th>
            <td>{{ $game->category }}</td>
        </tr>
        <tr>
            <th>Consolas:</th>
            <td>{{ $game->console }}</td>
        </tr>
        <tr>
            <th>Preço:</th>
            <td>{{ $game->price }}</td>
        </tr>
        <tr>
            <th>Imagem:</th>
            <td>{{ $game->url }}</td>
        </tr>
    </table>
</div>


<div class="col-lg-1">
    <a class="btn btn-primary" href="{{ url('game') }}"> Back</a>
</div>
<div class="hidden fixed top-0 right-0 px-6 py-4 sm:block">
        <a href="{{ url('/home') }}" class="text-sm text-gray-700 dark:text-gray-500 underline">Home</a>
    @else
        <a href="{{ route('login') }}" class="text-sm text-gray-700 dark:text-gray-500 underline">Log in</a>
    @endauth
</div>
    @endif
@endsection
