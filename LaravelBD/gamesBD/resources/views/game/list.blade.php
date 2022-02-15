@extends('layouts.app')

@section('content')
@if (Route::has('login'))
@auth
    <div class="card-header">{{ __('Jogos') }}</div>
    <div class="col-lg-1">
    </div>
    <div class="card-body">
        @if (session('status'))
            <div class="alert alert-success" role="alert">
                {{ session('status') }}
            </div>
        @endif
        <div class="col-lg-1">
            <a class="btn btn-success" href="{{ route('game.create') }}">Add</a>
        </div>
        <table class="table table-bordered">
            <tr>
                <th>Id</th>
                <th>Titulo</th>
                <th>Descrição</th>
                <th>Categoria</th>
                <th>Consolas</th>
                <th>Preço</th>
                <th>Imagem</th>
                <th>Operações</th>
            </tr>
            @php
                $i = 0;
            @endphp
            @foreach ($game as $game)
                <tr>
                    <td>{{ ++$i }}</td>
                    <td>{{ $game->name }}</td>
                    <td>{{ $game->description }}</td>
                    <td>{{ $game->category }}</td>
                    <td>{{ $game->console }}</td>
                    <td>{{ $game->price }}</td>
                    <td><img src="{{$game->url}}" alt="image"  width="120px"></td>
                    <td>
                        <form action="{{ route('game.destroy',$game->id) }}" method="POST">
                            <a class="btn btn-info" href="{{ route('game.show',$game->id) }}">Show</a>
                            <a class="btn btn-primary" href="{{ route('game.edit',$game->id) }}">Edit</a>
                            @csrf
                            @method('DELETE')
                            <button type="submit" class="btn btn-danger">Delete</button>
                        </form>
                    </td>
                </tr>
            @endforeach
        </table>

        

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
