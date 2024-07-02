package com.fivengers.blooming.config.contract;

public class KIP17BloomingToken {

    public static final String ABI_JSON = """
            [
            	{
            		"inputs": [
            			{
            				"internalType": "string",
            				"name": "name",
            				"type": "string"
            			},
            			{
            				"internalType": "string",
            				"name": "symbol",
            				"type": "string"
            			}
            		],
            		"payable": false,
            		"stateMutability": "nonpayable",
            		"type": "constructor"
            	},
            	{
            		"anonymous": false,
            		"inputs": [
            			{
            				"indexed": true,
            				"internalType": "address",
            				"name": "owner",
            				"type": "address"
            			},
            			{
            				"indexed": true,
            				"internalType": "address",
            				"name": "approved",
            				"type": "address"
            			},
            			{
            				"indexed": true,
            				"internalType": "uint256",
            				"name": "tokenId",
            				"type": "uint256"
            			}
            		],
            		"name": "Approval",
            		"type": "event"
            	},
            	{
            		"anonymous": false,
            		"inputs": [
            			{
            				"indexed": true,
            				"internalType": "address",
            				"name": "owner",
            				"type": "address"
            			},
            			{
            				"indexed": true,
            				"internalType": "address",
            				"name": "operator",
            				"type": "address"
            			},
            			{
            				"indexed": false,
            				"internalType": "bool",
            				"name": "approved",
            				"type": "bool"
            			}
            		],
            		"name": "ApprovalForAll",
            		"type": "event"
            	},
            	{
            		"anonymous": false,
            		"inputs": [
            			{
            				"indexed": true,
            				"internalType": "address",
            				"name": "account",
            				"type": "address"
            			}
            		],
            		"name": "MinterAdded",
            		"type": "event"
            	},
            	{
            		"anonymous": false,
            		"inputs": [
            			{
            				"indexed": true,
            				"internalType": "address",
            				"name": "account",
            				"type": "address"
            			}
            		],
            		"name": "MinterRemoved",
            		"type": "event"
            	},
            	{
            		"anonymous": false,
            		"inputs": [
            			{
            				"indexed": true,
            				"internalType": "address",
            				"name": "previousOwner",
            				"type": "address"
            			},
            			{
            				"indexed": true,
            				"internalType": "address",
            				"name": "newOwner",
            				"type": "address"
            			}
            		],
            		"name": "OwnershipTransferred",
            		"type": "event"
            	},
            	{
            		"anonymous": false,
            		"inputs": [
            			{
            				"indexed": false,
            				"internalType": "address",
            				"name": "account",
            				"type": "address"
            			}
            		],
            		"name": "Paused",
            		"type": "event"
            	},
            	{
            		"anonymous": false,
            		"inputs": [
            			{
            				"indexed": true,
            				"internalType": "address",
            				"name": "account",
            				"type": "address"
            			}
            		],
            		"name": "PauserAdded",
            		"type": "event"
            	},
            	{
            		"anonymous": false,
            		"inputs": [
            			{
            				"indexed": true,
            				"internalType": "address",
            				"name": "account",
            				"type": "address"
            			}
            		],
            		"name": "PauserRemoved",
            		"type": "event"
            	},
            	{
            		"anonymous": false,
            		"inputs": [
            			{
            				"indexed": true,
            				"internalType": "address",
            				"name": "from",
            				"type": "address"
            			},
            			{
            				"indexed": true,
            				"internalType": "address",
            				"name": "to",
            				"type": "address"
            			},
            			{
            				"indexed": true,
            				"internalType": "uint256",
            				"name": "tokenId",
            				"type": "uint256"
            			}
            		],
            		"name": "Transfer",
            		"type": "event"
            	},
            	{
            		"anonymous": false,
            		"inputs": [
            			{
            				"indexed": false,
            				"internalType": "address",
            				"name": "account",
            				"type": "address"
            			}
            		],
            		"name": "Unpaused",
            		"type": "event"
            	},
            	{
            		"constant": false,
            		"inputs": [
            			{
            				"internalType": "address",
            				"name": "account",
            				"type": "address"
            			}
            		],
            		"name": "addMinter",
            		"outputs": [],
            		"payable": false,
            		"stateMutability": "nonpayable",
            		"type": "function"
            	},
            	{
            		"constant": false,
            		"inputs": [
            			{
            				"internalType": "address",
            				"name": "account",
            				"type": "address"
            			}
            		],
            		"name": "addPauser",
            		"outputs": [],
            		"payable": false,
            		"stateMutability": "nonpayable",
            		"type": "function"
            	},
            	{
            		"constant": false,
            		"inputs": [
            			{
            				"internalType": "address",
            				"name": "user",
            				"type": "address"
            			},
            			{
            				"internalType": "uint256",
            				"name": "requestedCount",
            				"type": "uint256"
            			}
            		],
            		"name": "airDropMint",
            		"outputs": [],
            		"payable": false,
            		"stateMutability": "nonpayable",
            		"type": "function"
            	},
            	{
            		"constant": false,
            		"inputs": [
            			{
            				"internalType": "address",
            				"name": "to",
            				"type": "address"
            			},
            			{
            				"internalType": "uint256",
            				"name": "tokenId",
            				"type": "uint256"
            			}
            		],
            		"name": "approve",
            		"outputs": [],
            		"payable": false,
            		"stateMutability": "nonpayable",
            		"type": "function"
            	},
            	{
            		"constant": true,
            		"inputs": [
            			{
            				"internalType": "address",
            				"name": "owner",
            				"type": "address"
            			}
            		],
            		"name": "balanceOf",
            		"outputs": [
            			{
            				"internalType": "uint256",
            				"name": "",
            				"type": "uint256"
            			}
            		],
            		"payable": false,
            		"stateMutability": "view",
            		"type": "function"
            	},
            	{
            		"constant": false,
            		"inputs": [
            			{
            				"internalType": "uint256",
            				"name": "tokenId",
            				"type": "uint256"
            			}
            		],
            		"name": "burn",
            		"outputs": [],
            		"payable": false,
            		"stateMutability": "nonpayable",
            		"type": "function"
            	},
            	{
            		"constant": true,
            		"inputs": [
            			{
            				"internalType": "uint256",
            				"name": "tokenId",
            				"type": "uint256"
            			}
            		],
            		"name": "getApproved",
            		"outputs": [
            			{
            				"internalType": "address",
            				"name": "",
            				"type": "address"
            			}
            		],
            		"payable": false,
            		"stateMutability": "view",
            		"type": "function"
            	},
            	{
            		"constant": true,
            		"inputs": [
            			{
            				"internalType": "address",
            				"name": "owner",
            				"type": "address"
            			},
            			{
            				"internalType": "address",
            				"name": "operator",
            				"type": "address"
            			}
            		],
            		"name": "isApprovedForAll",
            		"outputs": [
            			{
            				"internalType": "bool",
            				"name": "",
            				"type": "bool"
            			}
            		],
            		"payable": false,
            		"stateMutability": "view",
            		"type": "function"
            	},
            	{
            		"constant": true,
            		"inputs": [
            			{
            				"internalType": "address",
            				"name": "account",
            				"type": "address"
            			}
            		],
            		"name": "isMinter",
            		"outputs": [
            			{
            				"internalType": "bool",
            				"name": "",
            				"type": "bool"
            			}
            		],
            		"payable": false,
            		"stateMutability": "view",
            		"type": "function"
            	},
            	{
            		"constant": true,
            		"inputs": [],
            		"name": "isOwner",
            		"outputs": [
            			{
            				"internalType": "bool",
            				"name": "",
            				"type": "bool"
            			}
            		],
            		"payable": false,
            		"stateMutability": "view",
            		"type": "function"
            	},
            	{
            		"constant": true,
            		"inputs": [
            			{
            				"internalType": "address",
            				"name": "account",
            				"type": "address"
            			}
            		],
            		"name": "isPauser",
            		"outputs": [
            			{
            				"internalType": "bool",
            				"name": "",
            				"type": "bool"
            			}
            		],
            		"payable": false,
            		"stateMutability": "view",
            		"type": "function"
            	},
            	{
            		"constant": true,
            		"inputs": [],
            		"name": "merkleRoot",
            		"outputs": [
            			{
            				"internalType": "bytes32",
            				"name": "",
            				"type": "bytes32"
            			}
            		],
            		"payable": false,
            		"stateMutability": "view",
            		"type": "function"
            	},
            	{
            		"constant": false,
            		"inputs": [
            			{
            				"internalType": "address",
            				"name": "to",
            				"type": "address"
            			},
            			{
            				"internalType": "uint256",
            				"name": "tokenId",
            				"type": "uint256"
            			}
            		],
            		"name": "mint",
            		"outputs": [
            			{
            				"internalType": "bool",
            				"name": "",
            				"type": "bool"
            			}
            		],
            		"payable": false,
            		"stateMutability": "nonpayable",
            		"type": "function"
            	},
            	{
            		"constant": false,
            		"inputs": [
            			{
            				"internalType": "address",
            				"name": "to",
            				"type": "address"
            			},
            			{
            				"internalType": "uint256",
            				"name": "tokenId",
            				"type": "uint256"
            			},
            			{
            				"internalType": "string",
            				"name": "tokenURI",
            				"type": "string"
            			}
            		],
            		"name": "mintWithTokenURI",
            		"outputs": [
            			{
            				"internalType": "bool",
            				"name": "",
            				"type": "bool"
            			}
            		],
            		"payable": false,
            		"stateMutability": "nonpayable",
            		"type": "function"
            	},
            	{
            		"constant": true,
            		"inputs": [],
            		"name": "mintingInformation",
            		"outputs": [
            			{
            				"internalType": "uint256[7]",
            				"name": "",
            				"type": "uint256[7]"
            			}
            		],
            		"payable": false,
            		"stateMutability": "view",
            		"type": "function"
            	},
            	{
            		"constant": true,
            		"inputs": [],
            		"name": "name",
            		"outputs": [
            			{
            				"internalType": "string",
            				"name": "",
            				"type": "string"
            			}
            		],
            		"payable": false,
            		"stateMutability": "view",
            		"type": "function"
            	},
            	{
            		"constant": true,
            		"inputs": [],
            		"name": "owner",
            		"outputs": [
            			{
            				"internalType": "address payable",
            				"name": "",
            				"type": "address"
            			}
            		],
            		"payable": false,
            		"stateMutability": "view",
            		"type": "function"
            	},
            	{
            		"constant": true,
            		"inputs": [
            			{
            				"internalType": "uint256",
            				"name": "tokenId",
            				"type": "uint256"
            			}
            		],
            		"name": "ownerOf",
            		"outputs": [
            			{
            				"internalType": "address",
            				"name": "",
            				"type": "address"
            			}
            		],
            		"payable": false,
            		"stateMutability": "view",
            		"type": "function"
            	},
            	{
            		"constant": false,
            		"inputs": [],
            		"name": "pause",
            		"outputs": [],
            		"payable": false,
            		"stateMutability": "nonpayable",
            		"type": "function"
            	},
            	{
            		"constant": true,
            		"inputs": [],
            		"name": "paused",
            		"outputs": [
            			{
            				"internalType": "bool",
            				"name": "",
            				"type": "bool"
            			}
            		],
            		"payable": false,
            		"stateMutability": "view",
            		"type": "function"
            	},
            	{
            		"constant": false,
            		"inputs": [
            			{
            				"internalType": "uint256",
            				"name": "requestedCount",
            				"type": "uint256"
            			}
            		],
            		"name": "publicMint",
            		"outputs": [],
            		"payable": true,
            		"stateMutability": "payable",
            		"type": "function"
            	},
            	{
            		"constant": true,
            		"inputs": [],
            		"name": "publicMintEnabled",
            		"outputs": [
            			{
            				"internalType": "bool",
            				"name": "",
            				"type": "bool"
            			}
            		],
            		"payable": false,
            		"stateMutability": "view",
            		"type": "function"
            	},
            	{
            		"constant": false,
            		"inputs": [],
            		"name": "renounceMinter",
            		"outputs": [],
            		"payable": false,
            		"stateMutability": "nonpayable",
            		"type": "function"
            	},
            	{
            		"constant": false,
            		"inputs": [],
            		"name": "renounceOwnership",
            		"outputs": [],
            		"payable": false,
            		"stateMutability": "nonpayable",
            		"type": "function"
            	},
            	{
            		"constant": false,
            		"inputs": [],
            		"name": "renouncePauser",
            		"outputs": [],
            		"payable": false,
            		"stateMutability": "nonpayable",
            		"type": "function"
            	},
            	{
            		"constant": false,
            		"inputs": [
            			{
            				"internalType": "bool",
            				"name": "_state",
            				"type": "bool"
            			}
            		],
            		"name": "reveal",
            		"outputs": [],
            		"payable": false,
            		"stateMutability": "nonpayable",
            		"type": "function"
            	},
            	{
            		"constant": true,
            		"inputs": [],
            		"name": "revealed",
            		"outputs": [
            			{
            				"internalType": "bool",
            				"name": "",
            				"type": "bool"
            			}
            		],
            		"payable": false,
            		"stateMutability": "view",
            		"type": "function"
            	},
            	{
            		"constant": false,
            		"inputs": [
            			{
            				"internalType": "address",
            				"name": "from",
            				"type": "address"
            			},
            			{
            				"internalType": "address",
            				"name": "to",
            				"type": "address"
            			},
            			{
            				"internalType": "uint256",
            				"name": "tokenId",
            				"type": "uint256"
            			}
            		],
            		"name": "safeTransferFrom",
            		"outputs": [],
            		"payable": false,
            		"stateMutability": "nonpayable",
            		"type": "function"
            	},
            	{
            		"constant": false,
            		"inputs": [
            			{
            				"internalType": "address",
            				"name": "from",
            				"type": "address"
            			},
            			{
            				"internalType": "address",
            				"name": "to",
            				"type": "address"
            			},
            			{
            				"internalType": "uint256",
            				"name": "tokenId",
            				"type": "uint256"
            			},
            			{
            				"internalType": "bytes",
            				"name": "_data",
            				"type": "bytes"
            			}
            		],
            		"name": "safeTransferFrom",
            		"outputs": [],
            		"payable": false,
            		"stateMutability": "nonpayable",
            		"type": "function"
            	},
            	{
            		"constant": false,
            		"inputs": [
            			{
            				"internalType": "address",
            				"name": "to",
            				"type": "address"
            			},
            			{
            				"internalType": "bool",
            				"name": "approved",
            				"type": "bool"
            			}
            		],
            		"name": "setApprovalForAll",
            		"outputs": [],
            		"payable": false,
            		"stateMutability": "nonpayable",
            		"type": "function"
            	},
            	{
            		"constant": false,
            		"inputs": [
            			{
            				"internalType": "string",
            				"name": "_newBaseURI",
            				"type": "string"
            			}
            		],
            		"name": "setBaseURI",
            		"outputs": [],
            		"payable": false,
            		"stateMutability": "nonpayable",
            		"type": "function"
            	},
            	{
            		"constant": false,
            		"inputs": [
            			{
            				"internalType": "bytes32",
            				"name": "_merkleRoot",
            				"type": "bytes32"
            			}
            		],
            		"name": "setMerkleRoot",
            		"outputs": [],
            		"payable": false,
            		"stateMutability": "nonpayable",
            		"type": "function"
            	},
            	{
            		"constant": false,
            		"inputs": [
            			{
            				"internalType": "string",
            				"name": "_newNotRevealedURI",
            				"type": "string"
            			}
            		],
            		"name": "setNotRevealedURI",
            		"outputs": [],
            		"payable": false,
            		"stateMutability": "nonpayable",
            		"type": "function"
            	},
            	{
            		"constant": false,
            		"inputs": [
            			{
            				"internalType": "bool",
            				"name": "_state",
            				"type": "bool"
            			}
            		],
            		"name": "setPublicMintEnabled",
            		"outputs": [],
            		"payable": false,
            		"stateMutability": "nonpayable",
            		"type": "function"
            	},
            	{
            		"constant": false,
            		"inputs": [
            			{
            				"internalType": "bool",
            				"name": "_state",
            				"type": "bool"
            			}
            		],
            		"name": "setWhitelistMintEnabled",
            		"outputs": [],
            		"payable": false,
            		"stateMutability": "nonpayable",
            		"type": "function"
            	},
            	{
            		"constant": false,
            		"inputs": [
            			{
            				"internalType": "uint256",
            				"name": "newAntibotInterval",
            				"type": "uint256"
            			},
            			{
            				"internalType": "uint256",
            				"name": "newMintLimitPerBlock",
            				"type": "uint256"
            			},
            			{
            				"internalType": "uint256",
            				"name": "newMintLimitPerSale",
            				"type": "uint256"
            			},
            			{
            				"internalType": "uint256",
            				"name": "newMintStartBlockNumber",
            				"type": "uint256"
            			},
            			{
            				"internalType": "uint256",
            				"name": "newMintIndexForSale",
            				"type": "uint256"
            			},
            			{
            				"internalType": "uint256",
            				"name": "newMaxSaleAmount",
            				"type": "uint256"
            			},
            			{
            				"internalType": "uint256",
            				"name": "newMintPrice",
            				"type": "uint256"
            			}
            		],
            		"name": "setupSale",
            		"outputs": [],
            		"payable": false,
            		"stateMutability": "nonpayable",
            		"type": "function"
            	},
            	{
            		"constant": true,
            		"inputs": [
            			{
            				"internalType": "bytes4",
            				"name": "interfaceId",
            				"type": "bytes4"
            			}
            		],
            		"name": "supportsInterface",
            		"outputs": [
            			{
            				"internalType": "bool",
            				"name": "",
            				"type": "bool"
            			}
            		],
            		"payable": false,
            		"stateMutability": "view",
            		"type": "function"
            	},
            	{
            		"constant": true,
            		"inputs": [],
            		"name": "symbol",
            		"outputs": [
            			{
            				"internalType": "string",
            				"name": "",
            				"type": "string"
            			}
            		],
            		"payable": false,
            		"stateMutability": "view",
            		"type": "function"
            	},
            	{
            		"constant": true,
            		"inputs": [
            			{
            				"internalType": "uint256",
            				"name": "index",
            				"type": "uint256"
            			}
            		],
            		"name": "tokenByIndex",
            		"outputs": [
            			{
            				"internalType": "uint256",
            				"name": "",
            				"type": "uint256"
            			}
            		],
            		"payable": false,
            		"stateMutability": "view",
            		"type": "function"
            	},
            	{
            		"constant": true,
            		"inputs": [
            			{
            				"internalType": "address",
            				"name": "owner",
            				"type": "address"
            			},
            			{
            				"internalType": "uint256",
            				"name": "index",
            				"type": "uint256"
            			}
            		],
            		"name": "tokenOfOwnerByIndex",
            		"outputs": [
            			{
            				"internalType": "uint256",
            				"name": "",
            				"type": "uint256"
            			}
            		],
            		"payable": false,
            		"stateMutability": "view",
            		"type": "function"
            	},
            	{
            		"constant": true,
            		"inputs": [
            			{
            				"internalType": "uint256",
            				"name": "tokenId",
            				"type": "uint256"
            			}
            		],
            		"name": "tokenURI",
            		"outputs": [
            			{
            				"internalType": "string",
            				"name": "",
            				"type": "string"
            			}
            		],
            		"payable": false,
            		"stateMutability": "view",
            		"type": "function"
            	},
            	{
            		"constant": true,
            		"inputs": [],
            		"name": "totalSupply",
            		"outputs": [
            			{
            				"internalType": "uint256",
            				"name": "",
            				"type": "uint256"
            			}
            		],
            		"payable": false,
            		"stateMutability": "view",
            		"type": "function"
            	},
            	{
            		"constant": false,
            		"inputs": [
            			{
            				"internalType": "address",
            				"name": "from",
            				"type": "address"
            			},
            			{
            				"internalType": "address",
            				"name": "to",
            				"type": "address"
            			},
            			{
            				"internalType": "uint256",
            				"name": "tokenId",
            				"type": "uint256"
            			}
            		],
            		"name": "transferFrom",
            		"outputs": [],
            		"payable": false,
            		"stateMutability": "nonpayable",
            		"type": "function"
            	},
            	{
            		"constant": false,
            		"inputs": [
            			{
            				"internalType": "address payable",
            				"name": "newOwner",
            				"type": "address"
            			}
            		],
            		"name": "transferOwnership",
            		"outputs": [],
            		"payable": false,
            		"stateMutability": "nonpayable",
            		"type": "function"
            	},
            	{
            		"constant": false,
            		"inputs": [],
            		"name": "unpause",
            		"outputs": [],
            		"payable": false,
            		"stateMutability": "nonpayable",
            		"type": "function"
            	},
            	{
            		"constant": true,
            		"inputs": [
            			{
            				"internalType": "address",
            				"name": "",
            				"type": "address"
            			}
            		],
            		"name": "whitelistClaimed",
            		"outputs": [
            			{
            				"internalType": "bool",
            				"name": "",
            				"type": "bool"
            			}
            		],
            		"payable": false,
            		"stateMutability": "view",
            		"type": "function"
            	},
            	{
            		"constant": false,
            		"inputs": [
            			{
            				"internalType": "uint256",
            				"name": "requestedCount",
            				"type": "uint256"
            			},
            			{
            				"internalType": "bytes32[]",
            				"name": "_merkleProof",
            				"type": "bytes32[]"
            			}
            		],
            		"name": "whitelistMint",
            		"outputs": [],
            		"payable": true,
            		"stateMutability": "payable",
            		"type": "function"
            	},
            	{
            		"constant": true,
            		"inputs": [],
            		"name": "whitelistMintEnabled",
            		"outputs": [
            			{
            				"internalType": "bool",
            				"name": "",
            				"type": "bool"
            			}
            		],
            		"payable": false,
            		"stateMutability": "view",
            		"type": "function"
            	},
            	{
            		"constant": false,
            		"inputs": [],
            		"name": "withdraw",
            		"outputs": [],
            		"payable": false,
            		"stateMutability": "nonpayable",
            		"type": "function"
            	}
            ]
            """;
    public static String BYTE_CODE = "60806040526000601960006101000a81548160ff0219169083151502179055506000601960016101000a81548160ff0219169083151502179055506000601c60006101000a81548160ff0219169083151502179055503480156200006257600080fd5b50604051620063b4380380620063b4833981810160405260408110156200008857600080fd5b8101908080516040519392919084640100000000821115620000a957600080fd5b83820191506020820185811115620000c057600080fd5b8251866001820283011164010000000082111715620000de57600080fd5b8083526020830192505050908051906020019080838360005b8381101562000114578082015181840152602081019050620000f7565b50505050905090810190601f168015620001425780820380516001836020036101000a031916815260200191505b50604052602001805160405193929190846401000000008211156200016657600080fd5b838201915060208201858111156200017d57600080fd5b82518660018202830111640100000000821117156200019b57600080fd5b8083526020830192505050908051906020019080838360005b83811015620001d1578082015181840152602081019050620001b4565b50505050905090810190601f168015620001ff5780820380516001836020036101000a031916815260200191505b5060405250505081818181620002226301ffc9a760e01b6200040b60201b60201c565b6200023a6380ac58cd60e01b6200040b60201b60201c565b6200025263780e9d6360e01b6200040b60201b60201c565b81600990805190602001906200026a9291906200079a565b5080600a9080519060200190620002839291906200079a565b506200029c635b5e139f60e01b6200040b60201b60201c565b505033600c60006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550600c60009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16600073ffffffffffffffffffffffffffffffffffffffff167f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e060405160405180910390a36200036d336200051460201b60201c565b600160108190555050506200038f63eab83e2060e01b6200040b60201b60201c565b620003a763fac27f4660e01b6200040b60201b60201c565b620003bf6342966c6860e01b6200040b60201b60201c565b620003d0336200057560201b60201c565b6000601e60006101000a81548160ff02191690831515021790555062000403634d5507ff60e01b6200040b60201b60201c565b505062000849565b63ffffffff60e01b817bffffffffffffffffffffffffffffffffffffffffffffffffffffffff19161415620004a8576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252601b8152602001807f4b495031333a20696e76616c696420696e74657266616365206964000000000081525060200191505060405180910390fd5b6001600080837bffffffffffffffffffffffffffffffffffffffffffffffffffffffff19167bffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916815260200190815260200160002060006101000a81548160ff02191690831515021790555050565b6200052f81600d620005d660201b62004c251790919060201c565b8073ffffffffffffffffffffffffffffffffffffffff167f6ae172837ea30b801fbfcdd4108aa1d5bf8ff775444fd70256b44e6bf3dfc3f660405160405180910390a250565b6200059081601d620005d660201b62004c251790919060201c565b8073ffffffffffffffffffffffffffffffffffffffff167f6719d08c1888103bea251a4ed56406bd0c3e69723c8a1686e017e7bbe159b6f860405160405180910390a250565b620005e88282620006ba60201b60201c565b156200065c576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252601f8152602001807f526f6c65733a206163636f756e7420616c72656164792068617320726f6c650081525060200191505060405180910390fd5b60018260000160008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff0219169083151502179055505050565b60008073ffffffffffffffffffffffffffffffffffffffff168273ffffffffffffffffffffffffffffffffffffffff16141562000743576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401808060200182810382526022815260200180620063926022913960400191505060405180910390fd5b8260000160008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900460ff16905092915050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10620007dd57805160ff19168380011785556200080e565b828001600101855582156200080e579182015b828111156200080d578251825591602001919060010190620007f0565b5b5090506200081d919062000821565b5090565b6200084691905b808211156200084257600081600090555060010162000828565b5090565b90565b615b3980620008596000396000f3fe6080604052600436106102ae5760003560e01c80636ef8d66d11610175578063983b2d56116100dc578063b88d4fde11610095578063db4bec441161006f578063db4bec44146112b0578063e985e9c514611319578063f2c4ce1e146113a2578063f2fde38b1461146a576102ae565b8063b88d4fde14611067578063c87b56dd14611179578063d2cab0561461122d576102ae565b8063983b2d5614610e855780639865027514610ed6578063a22cb46514610eed578063a386756114610f4a578063aa271e1a14610fc1578063b767a0981461102a576102ae565b806382dc1ec41161012e57806382dc1ec414610cca5780638456cb5914610d1b5780638da5cb5b14610d325780638f32d59b14610d89578063940cd05b14610db857806395d89b4114610df5576102ae565b80636ef8d66d14610b6457806370a0823114610b7b578063715018a614610be057806375a1ed0814610bf75780637cb6475914610c52578063818668d714610c8d576102ae565b80633f4ba83a1161021957806350bb4e7f116101d257806350bb4e7f1461088a578063518302271461099457806355f804b3146109c35780635c975abb14610a8b5780636352211e14610aba5780636caede3d14610b35576102ae565b80633f4ba83a1461069257806340c10f19146106a957806342842e0e1461071c57806342966c681461079757806346fbf68e146107d25780634f6ccce71461083b576102ae565b80631dd8792b1161026b5780631dd8792b146104e557806323b872dd146105385780632db11544146105b35780632eb4a7ab146105e15780632f745c591461060c5780633ccfd60b1461067b576102ae565b806301ffc9a7146102b357806306fdde0314610325578063081812fc146103b5578063095ea7b3146104305780630f4161aa1461048b57806318160ddd146104ba575b600080fd5b3480156102bf57600080fd5b5061030b600480360360208110156102d657600080fd5b8101908080357bffffffffffffffffffffffffffffffffffffffffffffffffffffffff191690602001909291905050506114bb565b604051808215151515815260200191505060405180910390f35b34801561033157600080fd5b5061033a611522565b6040518080602001828103825283818151815260200191508051906020019080838360005b8381101561037a57808201518184015260208101905061035f565b50505050905090810190601f1680156103a75780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b3480156103c157600080fd5b506103ee600480360360208110156103d857600080fd5b81019080803590602001909291905050506115c4565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34801561043c57600080fd5b506104896004803603604081101561045357600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291908035906020019092919050505061165f565b005b34801561049757600080fd5b506104a06116f0565b604051808215151515815260200191505060405180910390f35b3480156104c657600080fd5b506104cf611703565b6040518082815260200191505060405180910390f35b3480156104f157600080fd5b506104fa611710565b6040518082600760200280838360005b8381101561052557808201518184015260208101905061050a565b5050505090500191505060405180910390f35b34801561054457600080fd5b506105b16004803603606081101561055b57600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803573ffffffffffffffffffffffffffffffffffffffff1690602001909291908035906020019092919050505061176a565b005b6105df600480360360208110156105c957600080fd5b81019080803590602001909291905050506117fd565b005b3480156105ed57600080fd5b506105f6611bc2565b6040518082815260200191505060405180910390f35b34801561061857600080fd5b506106656004803603604081101561062f57600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190505050611bc8565b6040518082815260200191505060405180910390f35b34801561068757600080fd5b50610690611c87565b005b34801561069e57600080fd5b506106a7611d96565b005b3480156106b557600080fd5b50610702600480360360408110156106cc57600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190505050611ef6565b604051808215151515815260200191505060405180910390f35b34801561072857600080fd5b506107956004803603606081101561073f57600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190505050611f6a565b005b3480156107a357600080fd5b506107d0600480360360208110156107ba57600080fd5b8101908080359060200190929190505050611f8a565b005b3480156107de57600080fd5b50610821600480360360208110156107f557600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050611ff5565b604051808215151515815260200191505060405180910390f35b34801561084757600080fd5b506108746004803603602081101561085e57600080fd5b8101908080359060200190929190505050612012565b6040518082815260200191505060405180910390f35b34801561089657600080fd5b5061097a600480360360608110156108ad57600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190803590602001906401000000008111156108f457600080fd5b82018360208201111561090657600080fd5b8035906020019184600183028401116401000000008311171561092857600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f820116905080830192505050505050509192919290505050612092565b604051808215151515815260200191505060405180910390f35b3480156109a057600080fd5b506109a9612111565b604051808215151515815260200191505060405180910390f35b3480156109cf57600080fd5b50610a89600480360360208110156109e657600080fd5b8101908080359060200190640100000000811115610a0357600080fd5b820183602082011115610a1557600080fd5b80359060200191846001830284011164010000000083111715610a3757600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f820116905080830192505050505050509192919290505050612124565b005b348015610a9757600080fd5b50610aa061219c565b604051808215151515815260200191505060405180910390f35b348015610ac657600080fd5b50610af360048036036020811015610add57600080fd5b81019080803590602001909291905050506121b3565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b348015610b4157600080fd5b50610b4a61227b565b604051808215151515815260200191505060405180910390f35b348015610b7057600080fd5b50610b7961228e565b005b348015610b8757600080fd5b50610bca60048036036020811015610b9e57600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050612299565b6040518082815260200191505060405180910390f35b348015610bec57600080fd5b50610bf561236e565b005b348015610c0357600080fd5b50610c5060048036036040811015610c1a57600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803590602001909291905050506124a9565b005b348015610c5e57600080fd5b50610c8b60048036036020811015610c7557600080fd5b81019080803590602001909291905050506125c5565b005b348015610c9957600080fd5b50610cc860048036036020811015610cb057600080fd5b8101908080351515906020019092919050505061262d565b005b348015610cd657600080fd5b50610d1960048036036020811015610ced57600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506126a8565b005b348015610d2757600080fd5b50610d30612712565b005b348015610d3e57600080fd5b50610d47612873565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b348015610d9557600080fd5b50610d9e61289d565b604051808215151515815260200191505060405180910390f35b348015610dc457600080fd5b50610df360048036036020811015610ddb57600080fd5b810190808035151590602001909291905050506128f5565b005b348015610e0157600080fd5b50610e0a612970565b6040518080602001828103825283818151815260200191508051906020019080838360005b83811015610e4a578082015181840152602081019050610e2f565b50505050905090810190601f168015610e775780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b348015610e9157600080fd5b50610ed460048036036020811015610ea857600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050612a12565b005b348015610ee257600080fd5b50610eeb612a7c565b005b348015610ef957600080fd5b50610f4860048036036040811015610f1057600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803515159060200190929190505050612a87565b005b348015610f5657600080fd5b50610fbf600480360360e0811015610f6d57600080fd5b8101908080359060200190929190803590602001909291908035906020019092919080359060200190929190803590602001909291908035906020019092919080359060200190929190505050612b18565b005b348015610fcd57600080fd5b5061101060048036036020811015610fe457600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050612bb0565b604051808215151515815260200191505060405180910390f35b34801561103657600080fd5b506110656004803603602081101561104d57600080fd5b81019080803515159060200190929190505050612bcd565b005b34801561107357600080fd5b506111776004803603608081101561108a57600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190803590602001906401000000008111156110f157600080fd5b82018360208201111561110357600080fd5b8035906020019184600183028401116401000000008311171561112557600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f820116905080830192505050505050509192919290505050612c48565b005b34801561118557600080fd5b506111b26004803603602081101561119c57600080fd5b8101908080359060200190929190505050612cba565b6040518080602001828103825283818151815260200191508051906020019080838360005b838110156111f25780820151818401526020810190506111d7565b50505050905090810190601f16801561121f5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b6112ae6004803603604081101561124357600080fd5b81019080803590602001909291908035906020019064010000000081111561126a57600080fd5b82018360208201111561127c57600080fd5b8035906020019184602083028401116401000000008311171561129e57600080fd5b9091929391929390505050612f79565b005b3480156112bc57600080fd5b506112ff600480360360208110156112d357600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919050505061334a565b604051808215151515815260200191505060405180910390f35b34801561132557600080fd5b506113886004803603604081101561133c57600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803573ffffffffffffffffffffffffffffffffffffffff16906020019092919050505061336a565b604051808215151515815260200191505060405180910390f35b3480156113ae57600080fd5b50611468600480360360208110156113c557600080fd5b81019080803590602001906401000000008111156113e257600080fd5b8201836020820111156113f457600080fd5b8035906020019184600183028401116401000000008311171561141657600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f8201169050808301925050505050505091929192905050506133fe565b005b34801561147657600080fd5b506114b96004803603602081101561148d57600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050613476565b005b6000806000837bffffffffffffffffffffffffffffffffffffffffffffffffffffffff19167bffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916815260200190815260200160002060009054906101000a900460ff169050919050565b606060098054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156115ba5780601f1061158f576101008083540402835291602001916115ba565b820191906000526020600020905b81548152906001019060200180831161159d57829003601f168201915b5050505050905090565b60006115cf826134fc565b611624576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252602b815260200180615a78602b913960400191505060405180910390fd5b6002600083815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff169050919050565b601e60009054906101000a900460ff16156116e2576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260108152602001807f5061757361626c653a207061757365640000000000000000000000000000000081525060200191505060405180910390fd5b6116ec828261356e565b5050565b601960019054906101000a900460ff1681565b6000600780549050905090565b611718615612565b611720615612565b6040518060e00160405280600f5481526020016010548152602001601154815260200160125481526020016014548152602001601554815260200160165481525090508091505090565b601e60009054906101000a900460ff16156117ed576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260108152602001807f5061757361626c653a207061757365640000000000000000000000000000000081525060200191505060405180910390fd5b6117f8838383613764565b505050565b601960019054906101000a900460ff1661187f576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252601f8152602001807f546865207075626c69632073616c65206973206e6f7420656e61626c6564210081525060200191505060405180910390fd5b436118d4600f54600e60003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020546137d390919063ffffffff16565b10611947576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260128152602001807f426f74206973206e6f7420616c6c6f776564000000000000000000000000000081525060200191505060405180910390fd5b6014544310156119bf576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252600f8152602001807f4e6f74207965742073746172746564000000000000000000000000000000000081525060200191505060405180910390fd5b6000811180156119d157506011548111155b611a26576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260218152602001806157d26021913960400191505060405180910390fd5b600160155401611a41826010546137d390919063ffffffff16565b1115611ab5576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260118152602001807f457863656564206d617820616d6f756e7400000000000000000000000000000081525060200191505060405180910390fd5b60125481611ac233612299565b011115611b37576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252601c8152602001807f457863656564206d617820616d6f756e742070657220706572736f6e0000000081525060200191505060405180910390fd5b60008090505b81811015611b7a57611b513360105461385b565b611b6760016010546137d390919063ffffffff16565b6010819055508080600101915050611b3d565b5043600e60003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208190555050565b601a5481565b6000611bd383612299565b8210611c2a576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252602a815260200180615816602a913960400191505060405180910390fd5b600560008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208281548110611c7457fe5b9060005260206000200154905092915050565b611c9033612bb0565b611ce5576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260308152602001806158406030913960400191505060405180910390fd5b733e944ca8b08a0a0d3245b05abf01586b9142f52c73ffffffffffffffffffffffffffffffffffffffff166108fc60646005470281611d2057fe5b049081150290604051600060405180830381858888f19350505050158015611d4c573d6000803e3d6000fd5b503373ffffffffffffffffffffffffffffffffffffffff166108fc479081150290604051600060405180830381858888f19350505050158015611d93573d6000803e3d6000fd5b50565b611d9f33611ff5565b611df4576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252603081526020018061577c6030913960400191505060405180910390fd5b601e60009054906101000a900460ff16611e76576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260148152602001807f5061757361626c653a206e6f742070617573656400000000000000000000000081525060200191505060405180910390fd5b6000601e60006101000a81548160ff0219169083151502179055507f5db9ee0a495bf2e6ff9c91a7834c1ba4fdd244a5e8aa4e537bd38aeae4b073aa33604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390a1565b6000611f0133612bb0565b611f56576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260308152602001806158406030913960400191505060405180910390fd5b611f60838361385b565b6001905092915050565b611f8583838360405180602001604052806000815250612c48565b505050565b611f94338261387c565b611fe9576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252602f815260200180615987602f913960400191505060405180910390fd5b611ff281613970565b50565b600061200b82601d61398590919063ffffffff16565b9050919050565b600061201c611703565b8210612073576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252602b815260200180615a07602b913960400191505060405180910390fd5b6007828154811061208057fe5b90600052602060002001549050919050565b600061209d33612bb0565b6120f2576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260308152602001806158406030913960400191505060405180910390fd5b6120fc848461385b565b6121068383613a63565b600190509392505050565b601960009054906101000a900460ff1681565b61212d33612bb0565b612182576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260308152602001806158406030913960400191505060405180910390fd5b8060179080519060200190612198929190615634565b5050565b6000601e60009054906101000a900460ff16905090565b6000806001600084815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff169050600073ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff161415612272576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260288152602001806158916028913960400191505060405180910390fd5b80915050919050565b601c60009054906101000a900460ff1681565b61229733613aed565b565b60008073ffffffffffffffffffffffffffffffffffffffff168273ffffffffffffffffffffffffffffffffffffffff161415612320576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260298152602001806159b66029913960400191505060405180910390fd5b612367600360008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020613b47565b9050919050565b61237661289d565b6123e8576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260208152602001807f4f776e61626c653a2063616c6c6572206973206e6f7420746865206f776e657281525060200191505060405180910390fd5b600073ffffffffffffffffffffffffffffffffffffffff16600c60009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff167f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e060405160405180910390a36000600c60006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550565b6124b233612bb0565b612507576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260308152602001806158406030913960400191505060405180910390fd5b6000811161257d576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252600c8152602001807f7a65726f2072657175657374000000000000000000000000000000000000000081525060200191505060405180910390fd5b60008090505b818110156125c0576125978360105461385b565b6125ad60016010546137d390919063ffffffff16565b6010819055508080600101915050612583565b505050565b6125ce33612bb0565b612623576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260308152602001806158406030913960400191505060405180910390fd5b80601a8190555050565b61263633612bb0565b61268b576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260308152602001806158406030913960400191505060405180910390fd5b80601960016101000a81548160ff02191690831515021790555050565b6126b133611ff5565b612706576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252603081526020018061577c6030913960400191505060405180910390fd5b61270f81613b55565b50565b61271b33611ff5565b612770576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252603081526020018061577c6030913960400191505060405180910390fd5b601e60009054906101000a900460ff16156127f3576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260108152602001807f5061757361626c653a207061757365640000000000000000000000000000000081525060200191505060405180910390fd5b6001601e60006101000a81548160ff0219169083151502179055507f62e78cea01bee320cd4e420270b5ea74000d11b0c9f74754ebdbfc544b05a25833604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390a1565b6000600c60009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16905090565b6000600c60009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614905090565b6128fe33612bb0565b612953576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260308152602001806158406030913960400191505060405180910390fd5b80601960006101000a81548160ff02191690831515021790555050565b6060600a8054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015612a085780601f106129dd57610100808354040283529160200191612a08565b820191906000526020600020905b8154815290600101906020018083116129eb57829003601f168201915b5050505050905090565b612a1b33612bb0565b612a70576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260308152602001806158406030913960400191505060405180910390fd5b612a7981613baf565b50565b612a8533613c09565b565b601e60009054906101000a900460ff1615612b0a576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260108152602001807f5061757361626c653a207061757365640000000000000000000000000000000081525060200191505060405180910390fd5b612b148282613c63565b5050565b612b2133612bb0565b612b76576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260308152602001806158406030913960400191505060405180910390fd5b86600f8190555085601181905550846012819055508360148190555082601081905550816015819055508060168190555050505050505050565b6000612bc682600d61398590919063ffffffff16565b9050919050565b612bd633612bb0565b612c2b576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260308152602001806158406030913960400191505060405180910390fd5b80601c60006101000a81548160ff02191690831515021790555050565b612c5384848461176a565b612c5f84848484613e06565b612cb4576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260308152602001806159576030913960400191505060405180910390fd5b50505050565b6060612cc5826134fc565b612d1a576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252602e81526020018061574e602e913960400191505060405180910390fd5b60001515601960009054906101000a900460ff1615151415612e57576060612d40614368565b90506000815111612d605760405180602001604052806000815250612e4f565b80612d6a8461440a565b6040516020018083805190602001908083835b60208310612da05780518252602082019150602081019050602083039250612d7d565b6001836020036101000a03801982511681845116808217855250505050505090500182805190602001908083835b60208310612df15780518252602082019150602081019050602083039250612dce565b6001836020036101000a038019825116818451168082178552505050505050905001807f2e6a736f6e000000000000000000000000000000000000000000000000000000815250600501925050506040516020818303038152906040525b915050612f74565b6060612e61614537565b90506000815111612e815760405180602001604052806000815250612f70565b80612e8b8461440a565b6040516020018083805190602001908083835b60208310612ec15780518252602082019150602081019050602083039250612e9e565b6001836020036101000a03801982511681845116808217855250505050505090500182805190602001908083835b60208310612f125780518252602082019150602081019050602083039250612eef565b6001836020036101000a038019825116818451168082178552505050505050905001807f2e6a736f6e000000000000000000000000000000000000000000000000000000815250600501925050506040516020818303038152906040525b9150505b919050565b601c60009054906101000a900460ff16612fde576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401808060200182810382526022815260200180615a326022913960400191505060405180910390fd5b612ff3836016546145d990919063ffffffff16565b3414613067576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252600f8152602001807f4e6f7420656e6f756768204b6c6179000000000000000000000000000000000081525060200191505060405180910390fd5b601b60003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900460ff1615613127576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260188152602001807f4164647265737320616c726561647920636c61696d656421000000000000000081525060200191505060405180910390fd5b60008311801561313957506011548311155b61318e576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260218152602001806157d26021913960400191505060405180910390fd5b600033604051602001808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1660601b8152601401915050604051602081830303815290604052805190602001209050613236838380806020026020016040519081016040528093929190818152602001838360200280828437600081840152601f19601f82011690508083019250505050505050601a548361465f565b6132a8576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252600e8152602001807f496e76616c69642070726f6f662100000000000000000000000000000000000081525060200191505060405180910390fd5b60008090505b848110156132eb576132c23360105461385b565b6132d860016010546137d390919063ffffffff16565b60108190555080806001019150506132ae565b506001601b60003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff02191690831515021790555050505050565b601b6020528060005260406000206000915054906101000a900460ff1681565b6000600460008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900460ff16905092915050565b61340733612bb0565b61345c576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260308152602001806158406030913960400191505060405180910390fd5b8060189080519060200190613472929190615634565b5050565b61347e61289d565b6134f0576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260208152602001807f4f776e61626c653a2063616c6c6572206973206e6f7420746865206f776e657281525060200191505060405180910390fd5b6134f981614676565b50565b6000806001600084815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff169050600073ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff161415915050919050565b6000613579826121b3565b90508073ffffffffffffffffffffffffffffffffffffffff168373ffffffffffffffffffffffffffffffffffffffff16141561361d576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260208152602001807f4b495031373a20617070726f76616c20746f2063757272656e74206f776e657281525060200191505060405180910390fd5b8073ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16148061365d575061365c813361336a565b5b6136b2576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401808060200182810382526037815260200180615aa36037913960400191505060405180910390fd5b826002600084815260200190815260200160002060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550818373ffffffffffffffffffffffffffffffffffffffff168273ffffffffffffffffffffffffffffffffffffffff167f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b92560405160405180910390a4505050565b61376e338261387c565b6137c3576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260308152602001806159056030913960400191505060405180910390fd5b6137ce8383836147bc565b505050565b600080828401905083811015613851576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252601b8152602001807f536166654d6174683a206164646974696f6e206f766572666c6f77000000000081525060200191505060405180910390fd5b8091505092915050565b61386582826147e0565b61386f82826149f8565b61387881614abf565b5050565b6000613887826134fc565b6138dc576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252602b815260200180615ada602b913960400191505060405180910390fd5b60006138e7836121b3565b90508073ffffffffffffffffffffffffffffffffffffffff168473ffffffffffffffffffffffffffffffffffffffff16148061395657508373ffffffffffffffffffffffffffffffffffffffff1661393e846115c4565b73ffffffffffffffffffffffffffffffffffffffff16145b806139675750613966818561336a565b5b91505092915050565b61398261397c826121b3565b82614b0b565b50565b60008073ffffffffffffffffffffffffffffffffffffffff168273ffffffffffffffffffffffffffffffffffffffff161415613a0c576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260228152602001806159356022913960400191505060405180910390fd5b8260000160008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900460ff16905092915050565b613a6c826134fc565b613ac1576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252602b8152602001806158b9602b913960400191505060405180910390fd5b80600b60008481526020019081526020016000209080519060200190613ae8929190615634565b505050565b613b0181601d614b6890919063ffffffff16565b8073ffffffffffffffffffffffffffffffffffffffff167fcd265ebaf09df2871cc7bd4133404a235ba12eff2041bb89d9c714a2621c7c7e60405160405180910390a250565b600081600001549050919050565b613b6981601d614c2590919063ffffffff16565b8073ffffffffffffffffffffffffffffffffffffffff167f6719d08c1888103bea251a4ed56406bd0c3e69723c8a1686e017e7bbe159b6f860405160405180910390a250565b613bc381600d614c2590919063ffffffff16565b8073ffffffffffffffffffffffffffffffffffffffff167f6ae172837ea30b801fbfcdd4108aa1d5bf8ff775444fd70256b44e6bf3dfc3f660405160405180910390a250565b613c1d81600d614b6890919063ffffffff16565b8073ffffffffffffffffffffffffffffffffffffffff167fe94479a9f7e1952cc78f2d6baab678adc1b772d936c6583def489e524cb6669260405160405180910390a250565b3373ffffffffffffffffffffffffffffffffffffffff168273ffffffffffffffffffffffffffffffffffffffff161415613d05576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260188152602001807f4b495031373a20617070726f766520746f2063616c6c6572000000000000000081525060200191505060405180910390fd5b80600460003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff0219169083151502179055508173ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff167f17307eab39ab6107e8899845ad3d59bd9653f200f220920489ca2b5937696c3183604051808215151515815260200191505060405180910390a35050565b6000806060613e2a8673ffffffffffffffffffffffffffffffffffffffff16614d00565b613e3957600192505050614360565b8573ffffffffffffffffffffffffffffffffffffffff1663150b7a0260e01b33898888604051602401808573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200183815260200180602001828103825283818151815260200191508051906020019080838360005b83811015613f09578082015181840152602081019050613eee565b50505050905090810190601f168015613f365780820380516001836020036101000a031916815260200191505b5095505050505050604051602081830303815290604052907bffffffffffffffffffffffffffffffffffffffffffffffffffffffff19166020820180517bffffffffffffffffffffffffffffffffffffffffffffffffffffffff83818316178352505050506040518082805190602001908083835b60208310613fce5780518252602082019150602081019050602083039250613fab565b6001836020036101000a0380198251168184511680821785525050505050509050019150506000604051808303816000865af19150503d8060008114614030576040519150601f19603f3d011682016040523d82523d6000602084013e614035565b606091505b50809250819350505060008151141580156140b9575063150b7a0260e01b7bffffffffffffffffffffffffffffffffffffffffffffffffffffffff191681806020019051602081101561408757600080fd5b81019080805190602001909291905050507bffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916145b156140c957600192505050614360565b8573ffffffffffffffffffffffffffffffffffffffff16636745782b60e01b33898888604051602401808573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200183815260200180602001828103825283818151815260200191508051906020019080838360005b8381101561419957808201518184015260208101905061417e565b50505050905090810190601f1680156141c65780820380516001836020036101000a031916815260200191505b5095505050505050604051602081830303815290604052907bffffffffffffffffffffffffffffffffffffffffffffffffffffffff19166020820180517bffffffffffffffffffffffffffffffffffffffffffffffffffffffff83818316178352505050506040518082805190602001908083835b6020831061425e578051825260208201915060208101905060208303925061423b565b6001836020036101000a0380198251168184511680821785525050505050509050019150506000604051808303816000865af19150503d80600081146142c0576040519150601f19603f3d011682016040523d82523d6000602084013e6142c5565b606091505b50809250819350505060008151141580156143495750636745782b60e01b7bffffffffffffffffffffffffffffffffffffffffffffffffffffffff191681806020019051602081101561431757600080fd5b81019080805190602001909291905050507bffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916145b1561435957600192505050614360565b6000925050505b949350505050565b606060188054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156144005780601f106143d557610100808354040283529160200191614400565b820191906000526020600020905b8154815290600101906020018083116143e357829003601f168201915b5050505050905090565b60606000821415614452576040518060400160405280600181526020017f30000000000000000000000000000000000000000000000000000000000000008152509050614532565b600082905060005b6000821461447c578080600101915050600a828161447457fe5b04915061445a565b6060816040519080825280601f01601f1916602001820160405280156144b15781602001600182028038833980820191505090505b50905060006001830390505b6000861461452a57600a86816144cf57fe5b0660300160f81b828280600190039350815181106144e957fe5b60200101907effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916908160001a905350600a868161452257fe5b0495506144bd565b819450505050505b919050565b606060178054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156145cf5780601f106145a4576101008083540402835291602001916145cf565b820191906000526020600020905b8154815290600101906020018083116145b257829003601f168201915b5050505050905090565b6000808314156145ec5760009050614659565b60008284029050828482816145fd57fe5b0414614654576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260218152602001806158e46021913960400191505060405180910390fd5b809150505b92915050565b60008261466c8584614d13565b1490509392505050565b600073ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff1614156146fc576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260268152602001806157ac6026913960400191505060405180910390fd5b8073ffffffffffffffffffffffffffffffffffffffff16600c60009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff167f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e060405160405180910390a380600c60006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050565b6147c7838383614d7e565b6147d18382614fd9565b6147db82826149f8565b505050565b600073ffffffffffffffffffffffffffffffffffffffff168273ffffffffffffffffffffffffffffffffffffffff161415614883576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252601f8152602001807f4b495031373a206d696e7420746f20746865207a65726f20616464726573730081525060200191505060405180910390fd5b61488c816134fc565b156148ff576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252601b8152602001807f4b495031373a20746f6b656e20616c7265616479206d696e746564000000000081525060200191505060405180910390fd5b816001600083815260200190815260200160002060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550614998600360008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020615177565b808273ffffffffffffffffffffffffffffffffffffffff16600073ffffffffffffffffffffffffffffffffffffffff167fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef60405160405180910390a45050565b600560008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020805490506006600083815260200190815260200160002081905550600560008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208190806001815401808255809150509060018203906000526020600020016000909192909190915055505050565b6007805490506008600083815260200190815260200160002081905550600781908060018154018082558091505090600182039060005260206000200160009091929091909150555050565b614b15828261518d565b6000600b600083815260200190815260200160002080546001816001161561010002031660029004905014614b6457600b60008281526020019081526020016000206000614b6391906156b4565b5b5050565b614b728282613985565b614bc7576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260218152602001806158706021913960400191505060405180910390fd5b60008260000160008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff0219169083151502179055505050565b614c2f8282613985565b15614ca2576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252601f8152602001807f526f6c65733a206163636f756e7420616c72656164792068617320726f6c650081525060200191505060405180910390fd5b60018260000160008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff0219169083151502179055505050565b600080823b905060008111915050919050565b60008082905060008090505b8451811015614d73576000858281518110614d3657fe5b60200260200101519050808311614d5857614d5183826151c7565b9250614d65565b614d6281846151c7565b92505b508080600101915050614d1f565b508091505092915050565b8273ffffffffffffffffffffffffffffffffffffffff16614d9e826121b3565b73ffffffffffffffffffffffffffffffffffffffff1614614e0a576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260288152602001806159df6028913960400191505060405180910390fd5b600073ffffffffffffffffffffffffffffffffffffffff168273ffffffffffffffffffffffffffffffffffffffff161415614e90576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260238152602001806157f36023913960400191505060405180910390fd5b614e99816151de565b614ee0600360008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002061529c565b614f27600360008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020615177565b816001600083815260200190815260200160002060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550808273ffffffffffffffffffffffffffffffffffffffff168473ffffffffffffffffffffffffffffffffffffffff167fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef60405160405180910390a4505050565b60006150316001600560008673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020805490506152bf90919063ffffffff16565b905060006006600084815260200190815260200160002054905081811461511e576000600560008673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020838154811061509e57fe5b9060005260206000200154905080600560008773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002083815481106150f657fe5b9060005260206000200181905550816006600083815260200190815260200160002081905550505b600560008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002080548091906001900361517091906156fc565b5050505050565b6001816000016000828254019250508190555050565b6151978282615309565b6151a18282614fd9565b600060066000838152602001908152602001600020819055506151c381615498565b5050565b600082600052816020526040600020905092915050565b600073ffffffffffffffffffffffffffffffffffffffff166002600083815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16146152995760006002600083815260200190815260200160002060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505b50565b6152b4600182600001546152bf90919063ffffffff16565b816000018190555050565b600061530183836040518060400160405280601e81526020017f536166654d6174683a207375627472616374696f6e206f766572666c6f770000815250615552565b905092915050565b8173ffffffffffffffffffffffffffffffffffffffff16615329826121b3565b73ffffffffffffffffffffffffffffffffffffffff1614615395576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401808060200182810382526024815260200180615a546024913960400191505060405180910390fd5b61539e816151de565b6153e5600360008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002061529c565b60006001600083815260200190815260200160002060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555080600073ffffffffffffffffffffffffffffffffffffffff168373ffffffffffffffffffffffffffffffffffffffff167fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef60405160405180910390a45050565b60006154b360016007805490506152bf90919063ffffffff16565b90506000600860008481526020019081526020016000205490506000600783815481106154dc57fe5b9060005260206000200154905080600783815481106154f757fe5b9060005260206000200181905550816008600083815260200190815260200160002081905550600780548091906001900361553291906156fc565b506000600860008681526020019081526020016000208190555050505050565b60008383111582906155ff576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825283818151815260200191508051906020019080838360005b838110156155c45780820151818401526020810190506155a9565b50505050905090810190601f1680156155f15780820380516001836020036101000a031916815260200191505b509250505060405180910390fd5b5060008385039050809150509392505050565b6040518060e00160405280600790602082028038833980820191505090505090565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061567557805160ff19168380011785556156a3565b828001600101855582156156a3579182015b828111156156a2578251825591602001919060010190615687565b5b5090506156b09190615728565b5090565b50805460018160011615610100020316600290046000825580601f106156da57506156f9565b601f0160209004906000526020600020908101906156f89190615728565b5b50565b815481835581811115615723578183600052602060002091820191016157229190615728565b5b505050565b61574a91905b8082111561574657600081600090555060010161572e565b5090565b9056fe4b495031374d657461646174613a2055524920717565727920666f72206e6f6e6578697374656e7420746f6b656e506175736572526f6c653a2063616c6c657220646f6573206e6f742068617665207468652050617573657220726f6c654f776e61626c653a206e6577206f776e657220697320746865207a65726f2061646472657373546f6f206d616e79207265717565737473206f72207a65726f20726571756573744b495031373a207472616e7366657220746f20746865207a65726f20616464726573734b49503137456e756d657261626c653a206f776e657220696e646578206f7574206f6620626f756e64734d696e746572526f6c653a2063616c6c657220646f6573206e6f74206861766520746865204d696e74657220726f6c65526f6c65733a206163636f756e7420646f6573206e6f74206861766520726f6c654b495031373a206f776e657220717565727920666f72206e6f6e6578697374656e7420746f6b656e4b495031374d657461646174613a2055524920736574206f66206e6f6e6578697374656e7420746f6b656e536166654d6174683a206d756c7469706c69636174696f6e206f766572666c6f774b495031373a207472616e736665722063616c6c6572206973206e6f74206f776e6572206e6f7220617070726f766564526f6c65733a206163636f756e7420697320746865207a65726f20616464726573734b495031373a207472616e7366657220746f206e6f6e204b49503137526563656976657220696d706c656d656e7465724b495031374275726e61626c653a2063616c6c6572206973206e6f74206f776e6572206e6f7220617070726f7665644b495031373a2062616c616e636520717565727920666f7220746865207a65726f20616464726573734b495031373a207472616e73666572206f6620746f6b656e2074686174206973206e6f74206f776e4b49503137456e756d657261626c653a20676c6f62616c20696e646578206f7574206f6620626f756e64735468652077686974656c6973742073616c65206973206e6f7420656e61626c6564214b495031373a206275726e206f6620746f6b656e2074686174206973206e6f74206f776e4b495031373a20617070726f76656420717565727920666f72206e6f6e6578697374656e7420746f6b656e4b495031373a20617070726f76652063616c6c6572206973206e6f74206f776e6572206e6f7220617070726f76656420666f7220616c6c4b495031373a206f70657261746f7220717565727920666f72206e6f6e6578697374656e7420746f6b656ea265627a7a72315820537f2a81b746a778b093e87f961d5ab1740dfa884a95ad470c348147f9db10e064736f6c63430005110032526f6c65733a206163636f756e7420697320746865207a65726f2061646472657373";
}
